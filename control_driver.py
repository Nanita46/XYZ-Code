
# Authors:
#   * XYZ Code Spaceappchallengepty
#     
import sys
from std_msgs.msg import String
from std_msgs.msg import Empty
from sensor_msgs.msg import CompressedImage
from geometry_msgs.msg import Twist
import rospy
from ar_drone_wrapper.msg import Navdata
from imutils import paths
import numpy as np
import imutils
import cv2
from libardrone import ardrone
from multiprocessing import Process
import time


drone = None
pub_nav_data = rospy.Publisher("/ardrone/navdata", Navdata, queue_size=1)
front_image_pub = rospy.Publisher("/ardrone/front_camera/raw_image_compressed", CompressedImage, queue_size=10)


def images(drone):
    rospy.loginfo("Image info thread")
    if drone:
        drone.set_camera_view(True)
        msg = CompressedImage()
        msg.header.stamp = rospy.Time.now()
        msg.format = "jpeg"
        compressed_images = cv2.imencode('.jpg', drone.get_image())
        msg.data = np.array(compressed_images[1]).tostring()
        front_image_pub.publish(msg)

        
        datos=dict()
        datos=nav_data(drone)
        print(datos[0])

        
    else:
        rospy.loginfo("No inicio")

def nav_data(drone):
    if drone:
        
        nav_data_drone = drone.get_navdata()
        data=nav_data_drone
        
    else:
        rospy.loginfo("No data to publish")
    return (data)

def cmd_vel(move_data):
    global drone
    
    if move_data.linear.x == -1:
        drone.move_right()
        
    elif move_data.linear.y == 1:
        drone.move_forward()
        
     
    elif move_data.linear.z == 1:
        drone.move_up()
        
      
    elif move_data.linear.x == 1:
        drone.move_left()
        
       
    elif move_data.linear.y == -1:
        drone.move_backward()
        
       
    elif move_data.linear.z == -1:
        drone.move_down()
        

    elif move_data.angular.x == -1:
        drone.turn_right()
        

    elif move_data.angular.x == 1:
        drone.turn_left()
        
#nuevo agregado
    elif move_data.angular.y == 2:
        drone.takeoff()
        
    elif move_data.angular.y == -2:
        drone.land()
        
    elif move_data.angular.z == 2:
        drone.reset()
        
    elif move_data.angular.z == -2:
    
        drone.hover()
        


    images(drone)
    

def takeoff(_data):
    global drone
    drone.takeoff()
    drone.hover()

def land(_data):
    global drone
    drone.land()

def reset(_data):
    global drone
    drone.reset()

def main(args):
    global drone
    rospy.init_node('control_driver', anonymous=True)
    rospy.loginfo("Starting drone connection")
    drone = ardrone.ARDrone(True)
    rospy.loginfo("Connection Success!!")
    drone.reset()
    cmd_vel_sub = rospy.Subscriber("/ardrone/cmd_vel", Twist, cmd_vel,  queue_size = 1)
    takeoff_sub = rospy.Subscriber("/ardrone/takeoff", Empty, takeoff,  queue_size = 1)
    land_sub = rospy.Subscriber("/ardrone/land", Empty, land,  queue_size = 1)
    reset_sub = rospy.Subscriber("/ardrone/reset", Empty, reset,  queue_size = 1)
    try:
        rospy.spin()
    except KeyboardInterrupt:
        drone.halt()
        nav_data_thread.terminate()
        print "Shutting down ROS ARDRONE DRIVER module"

if __name__ == '__main__':
    main(sys.argv)
