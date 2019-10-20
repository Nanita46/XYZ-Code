# XYZ-Code
NASA Space Apps Challenge 2019 participant

THE CHALLENGE

> Create an app to pilot an unmanned aerial system (UAS), such as a NASA space drone, utilizing the 6-axis gyro sensor within a smartphone or tablet. The piloting app can be combined with multiple sensors for flight precision and the best maneuverable flight techniques for off-Earth planetary drones.

<p align="center">
<img width="200" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/xyz-icon-20.jpg"><img width="400" height="200" src="https://www.nasa.gov/sites/default/files/thumbnails/image/nasa-logo-web-rgb.png"><img width="300" height="100" src="https://github.com/Nanita46/XYZ-Code/blob/master/ros-logo.png">
</p>




### Project objective 
***
<p style="text-align: justify;">An application developed for mobile devices as a solution to unmanned drone missions, which will be remotely piloted through the multi-platform application.</p>

<p align="center">
  
</p>

### What is XYZ?
***
**XYZ** is an application that grants the astronaut the ability to fly an unmanned aircraft (drone) from the comfort of his cell phone, tablet or PC without putting their lives at risk, improving the security, control and support during the research efforts of different planets throughout the universe. Aided by sensors used by the drone, it will be able to transmit image, video and valuable navigation data in the face of the climate adversities which will be present during the development of investigations.

### Development:
***
Several approaches were considered during the development phase, opting for using Android Studio combined with Python and ROS, working under a Linux platform (Ubuntu).

In order to design the controller some code snippets were adapted from previous AI courses, currently hosted at https://github.com/dsapandora/ar_drone_wrapper

The main application was developed using Python.

### Solution to the problem:
***
Create a controller to pilot an unmanned ship, to be used with an application installed on a mobile device, that will allow the astronaut to control said ship remotely, thus avoiding putting his life at risk and from which relevant information can be obtained, both of its route through images obtained using the camera, as well as its navigation data (battery %, altitude, movement on the x, y, z axes, etc.) which are required to demonstrate malfunctions and prevent equipment loss.

### System Architecture:
***
<p align="center">
  <img width="660" height="300" src="https://github.com/Nanita46/XYZ-Code/blob/master/diagrama_arquitectura.jpg">
</p>

### How it works:
***
The application consists of two essential parts: the first one is the app installed on the mobile device that provides the movement instructions; the second one is the server that receives these instructions, communicates them to the drone and waits for the return of the issued data (image and navigation), to later store the navigation data and retransmit the image to the app used by the astronaut in order to perform an optimal tour of the studied area.

It should be noted that this application is not limited to mobile devices, given that it can also be run on a normal computer.

### Manejo de la comunicacion entre dispositivos
***

Para realizar la comunicacion entre el dispositivo movil y el dron de la forma planteada en el proyecto, es necesario hacer uso de las redes mesh propuestas por el equipo DeltaProtocol, ganador del Space Apps Challenge 2018, cuya solucion fue plasmada de la siguiente manera:

"El sistema se basará en una red de malla construida siguiendo el protocolo LoRaWAN. Este protocolo permite la transmisión de datos a baja velocidad con un largo alcance y bajo consumo de energía. La red de malla está diseñada para funcionar como la red troncal que soportará las otras partes de la red de los sensores.

Elegimos una red de malla por dos razones fundamentales. Primero, una red de malla puede ser reconfigurada dinámicamente. Esto permite que la red continúe funcionando incluso si uno de los transceptores falla, casi sin tiempo de inactividad. Esta capacidad es extremadamente importante cuando se trabaja en entornos desafiantes como Marte. En segundo lugar, una red de malla es escalable. Requiere bajos costos de instalación y permite una fácil expansión y servicio por parte de los astronautas."

[![Movimientos del Dron]( <img width="300" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/XYZMOV.png">)](https://ak1.picdn.net/shutterstock/videos/9350111/preview/stock-footage-drone-yaw-left-right-quadcopter-beginner-guide-learn-to-fly-drones-yaw-rotates-the.mp4)

<p align="center"> <img width="300" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/Camar.png"> <img width="300" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/drone.png"></p>
 
<p align="center"> <img width="300" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/Sensor.png"> <img width="300" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/droid.png"></p>

### Resources:
***
- Android Studio                                                                                                                          - Python3 libraries (numpy, pygame, imutils, pip3)
- Java
- Ros Melodic
- Flask 1.2
- Sublime Text

### What's next?
***
- Sending the gyro sensor data to a server. This data transmission needs to be directly connected to the server; during the development stage Android Studio was used instead as a bridge between the mobile device and the server.
- Information needs to be sent to the drone through the use of ROS using the data provided by the gyro sensor, to be later processed by the drone according to the previously practiced routines. Flask intervenes during the data transmission between the server and the drone.
- Current movement scope is limited to Yaw Left and Yaw Right, aiming to expand the movement range such as inclination angles or turning around its axes towards later stages of development.
- Data is transferred using the network address of the drone using cmd_vel to store the drone movements.

### Challenges
***
Implementing the application for its possible use on any device. Further code development to add improvements.
La adaptacion del drone a las diferetes condiciones atmosfericas de cada planeta,quedara bajo la responsabilidad del astronauta, quien debera decidir que tipo de equipo utilizar según las diferentes variables existentes en el entorno. 

### Reference
> [Online]https://es.wikipedia.org/wiki/Anexo:Datos_de_los_planetas_del_sistema_solar [visited 20/10/2019]

> [Online]https://www.fullstackpython.com/flask.html [20/10/2019]

> [Online]http://wiki.ros.org/roscore [20/10/2019]

> [Online]https://developer.android.com/studio [20/10/2019]

> [Online]http://www.playsheep.de/drone/ [20/10/2019]

> [Online]https://github.com/dsapandora/ar_drone_wrapper.git [20/10/2019]

> [Online]https://elbauldelprogramador.com/giroscopio-acelerometro-movimientos-android/ [20/10/2019]

> [Online]https://ubunlog.com/android-studio-instalacion-ubuntu/ [20/10/2019]

> [Online]https://linuxize.com/post/how-to-install-flask-on-ubuntu-18-04/ [20/10/2019]

> [Online]https://github.com/SUPENTA/ardrone-sdk-android [20/10/2019]
