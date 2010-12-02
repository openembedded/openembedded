require bug-app.inc

DESCRIPTION = "Simple APP showing how to read/write to GPIO pins.  It prints to concierge.log the state of the 4 GPIO pins.  It's composed of two threads: one to read the status of the GPIO pin, and another to intermittently set GPIO pin 0 to high or low.  \
You can insert a wire from pin 0 to any other pin and see that it does indeed change.  Some example output:\
(GPIO pin 0 wired to GPIO pin 2)\
1010\
1111\
1010\
1111\
1010\
1111\
(wire pulled out)\
1110\
1111\
1110\
(GPIO pin 0 wired to pin 1)\
1100\
1111\
1100\
1111\
1100\
1111\
(wire pulled out)\
1110\
1111\
1110\
1111"
HOMEPAGE = "http://buglabs.net/applications/VHGPIOExample"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/571"

APIVERSION = ""
