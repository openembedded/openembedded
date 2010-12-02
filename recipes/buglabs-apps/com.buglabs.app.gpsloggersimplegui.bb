require bug-app.inc

DESCRIPTION = "YAGA: Yet Another GPS Application.  This one was made with the Physical BUG in mind without use of an internet connection:\
What it does:  Opens a frame and waits for a signal fix.  There is a label at the top of the frame indicating whether the module is utilizing an external or the on-board antenna.  you may toggle which antenna by pressing any button.  The red LED on the BUGLocate module will light up when using the external antenna.\
What it shows:  How to switch between internal and external antenna, how to dynamically update the text in a TextArea and Label, and how to use the functionalities framed in the IGPSModuleControl interface.\
--------------------------------------\
Please feel free to email me at john [at] buglabs.net for information. Or check out BUGLabs on IRC: irc://irc.freenode.net/buglabs ."
HOMEPAGE = "http://buglabs.net/applications/GPSLoggerSimpleGUI"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/204"

APIVERSION = ""

BROKEN = "1"
