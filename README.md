# XYZ-Code
Participación en el NASA Space App 2019

THE CHALLENGE

> Create an app to pilot an unmanned aerial system (UAS), such as a NASA space drone, utilizing the 6-axis gyro sensor within a smartphone or tablet. The piloting app can be combined with multiple sensors for flight precision and the best maneuverable flight techniques for off-Earth planetary drones.

<p align="center">
  <img width="400" height="200" src="https://github.com/Nanita46/XYZ-Code/blob/master/xyz-icon-20.jpg">
</p>


### Project objective 

<p style="text-align: justify;">An application developed in mobile devices for the solution of unmanned drone missions, which will be remotely piloted through the application.</p>

<p align="center">
  <img width="560" height="300" src="https://www.nasa.gov/sites/default/files/thumbnails/image/nasa-logo-web-rgb.png">
</p>

### What is XYZ?
**XYZ** It is an application that gives the astronaut the facility to fly an unmanned aircraft (drone) from the comfort of his cell phone without putting lives at risk, which gives us security, control and support in the investigation of planets In the universe. With the help of the sensors that the drone uses, it will be able to transmit image, video and valuable navigation information in the face of the adversities of the climate which will be present in the development of the investigation.

### Development:

Se plantearon varias ideas de desarrollo, optando por la utilizacion de Android Studio en combinacion con python y ros, tabajando sobre la plataforma Ubuntu.

Para el diseño del controlador se adptaron algunos códigos, que habian sido utilizados durante clase de inteligencia artificial con anterioridad, alojados en el repositorio https://github.com/dsapandora/ar_drone_wrapper, 

La aplicacion principal se esta desarrollando en python

### Solucion del problema:

Crear un controlador para pilotar una nave no tripulada, para ser utilizada desde una aplicacion instalada en un dispositivo movil, que permita al astronauta controlar dicha nave de forma remota, evitando asi poner en riesgo su vida y de la cual se podra obtener informacion relevante, tanto de su recorrido a traves de las imagenes obtenidas con la camara, como de su datos de navegacion (%bateria, altitude, movimiento sobre los ejes x, y, z, etc.) que son necesarios para evidenciar mal funcionamiento y evitar la perdida del equipo.

### Arquitectura:

<p align="center">
  <img width="460" height="300" src="https://github.com/Nanita46/XYZ-Code/blob/master/diagrama_arquitectura.jpg">
</p>

### Como funciona:

La aplicacion consta de dos partes escenciales, la primera es la app instalada en el dispositivo movil que se encarga de dar las instruciones de movimiento, la segunda el servidor que recibe dichas instrucciones, las comunica al drone y espera de regreso los datos (navegacion e imagen) emitidos, para proceder a almacenar los datos de navegacion y retransmitir la imagen a la app de la cual hace uso el astronauta, para realizar un optimo recorrido del area.

Cabe resaltar que dicha aplicacion no se limita unicamente a dispositivos moviles, ya que tambien puede ser ejecutar en un computador normal.


### Recursos:

- Android Studio                                                                                                                          - Python3 librerias (numpy, pygame, imutils, pip3)
- Java
- Ros Melodic
- Flask 1.2
- Sublime Text

### Whats next?

### Challenges

### Reference
> [Online]https://es.wikipedia.org/wiki/Anexo:Datos_de_los_planetas_del_sistema_solar [visited 20/10/2019]
> [Online]https://www.fullstackpython.com/flask.html [20/10/2019]

> [Online]http://wiki.ros.org/roscore [20/10/2019]

> [Online]https://developer.android.com/studio [20/10/2019]

> [Online]http://www.playsheep.de/drone/ [20/10/2019]

> [Online]https://github.com/dsapandora/ar_drone_wrapper.git [20/10/2019]
