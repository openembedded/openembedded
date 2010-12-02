require bug-app.inc

DESCRIPTION = "*UPDATED*\
After try  the first version on a physical BUG,  I made some changes:\
* The method *getCanvas()* it is set to use the default images. If you want to use you own images just provide  a valid path to a folder with some pictures in the Method *getCanvas()* at the * PhotoSlideshow.java *.\
* Start the animation using the mouse. Left click the image, hold the bottom, move the mouse to the direction you want to slide, and release  the bottom (On the bug it's touch screen).\
* Some performance improvement. \
Please feel free to leave your suggestions or comments.\
\
*Version 1*\
This is a simple implementation of a PHOTO SLIDESHOW for the bug. \
NOTE : * To test this application provide  a valid path to a folder with some pictures in the Method getCanvas() at the PhotoSlideshow.java *"
HOMEPAGE = "http://buglabs.net/applications/PhotoSlideshow"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/490"

APIVERSION = ""
