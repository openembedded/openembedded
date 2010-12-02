require bug-app.inc

DESCRIPTION = "This is a very simple application that flashes the built in blue and red LEDs on the VonHippel module.  The LCD module has a very simple interface.  It alows the user to pause the flashing of the LEDs and it displays what LED is currently on.  The code is commented so that anyone should be able to figure out what is going on with it.\
NOTE: This requires R1.4 on the physical bug in order to run.  Also, it was written in version 1.2.6.2 of the SDK, so I am not sure if it will work with a version less than that.\
Comments are appreciated!"
HOMEPAGE = "http://buglabs.net/applications/VonHippelTest"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.module.vonhippel com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/541"

APIVERSION = ""
