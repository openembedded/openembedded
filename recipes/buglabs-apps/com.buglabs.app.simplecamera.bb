require bug-app.inc

DESCRIPTION = "Application for the physical BUG that snaps a picture when any of the buttons (including the joystick) is pressed and released.  \
I whipped this up for the Come on down meet and greet 3/26/2008.\
The images are written to the MMC card at /home/buguser/images/image_#.jpg\
To access the images, either use an MMC card reader or scp them from the BUG to the host machine.\
scp -r root@10.10.10.10:/home/buguser/images .  \
That's temporary btw.  I'll extend the app to be a PublicWSProvider, zipping the folder and returning the zip through a GET request.\
"
HOMEPAGE = "http://buglabs.net/applications/SimpleCamera"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.bug.base com.buglabs.osgi service-tracker com.buglabs.common "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/151"

APIVERSION = ""
