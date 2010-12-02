require bug-app.inc

DESCRIPTION = "h2. DC Motor Controller\
This library provides an OSGi service that wraps DC motor controllers for access by other applications. That opens the door for generic motor control applications using the accelerometer, web services, robot logic etc. \
The interface is *IContinuousMotorControlProvider*, which provides for relative control of the motor as a percentage of the maximum supply voltage, and the motor runs continuously once a velocity is set. \
h2. Supported Controllers.\
* 'Sabertooth 2x5A':http://www.dimensionengineering.com/Sabertooth2X5.htm\
* 'Sabertooth 2x10A':http://www.dimensionengineering.com/Sabertooth2X10.htm\
* 'Sabertooth 2x25A':http://www.dimensionengineering.com/Sabertooth2X25.htm\
* 'SyRen 10A':http://www.dimensionengineering.com/SyRen10.htm\
* 'SyRen 25A':http://www.dimensionengineering.com/SyRen25.htm\
"
HOMEPAGE = "http://buglabs.net/applications/ContinuousMotorController"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/526"

APIVERSION = ""
