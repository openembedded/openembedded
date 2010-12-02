require bug-app.inc

DESCRIPTION = "An app that reads an image from the ICameraDevice and diplays it on the LCD.  Demo for rendering images to Canvases. \
Room for improvement: double buffering, scaling the image without consuming nearly 60% CPU.\
--------------------------------------\
Please feel free to email me at john [at] buglabs.net for information. Or check out BUGLabs on IRC: irc://irc.freenode.net/buglabs .\
"
HOMEPAGE = "http://buglabs.net/applications/ImageTest"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/159"

APIVERSION = ""
