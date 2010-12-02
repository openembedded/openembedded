require bug-app.inc

DESCRIPTION = "This application demonstrates how to use the API for the Von Hippel module, our upcoming breakout module.  To use this application with the Virtual BUG, or to take a look at some of the cool things you can do with this new module, you will need SDK release 1.1.6.19 or above (11/10/2008 release).\
This application is intended as a tutorial.  It's the Hello World of the Von Hippel module.  If an LED is inserted with lead into GPIO pin 1, and ground into GND, it will blink every second.  It does not work with R1.3 of the root filesystem because the IVonHippelModuleControl class was not implemented.  It works with the upcoming R1.4 of the kernel/rootfs."
HOMEPAGE = "http://buglabs.net/applications/VonHippelLEDBlinker"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/840"

APIVERSION = ""
