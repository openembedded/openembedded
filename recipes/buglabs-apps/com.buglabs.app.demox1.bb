require bug-app.inc

DESCRIPTION = "This is an enhanced version of the all popular BUGer  Security System.\
The Basics:\
The App uses a motion sensor and a camera.\
anytime a motion is detected, the camera takes a picture and stores it on the bug.\
By pointing a web browser to http://10.10.10.10/buger\
you will be able to see a log of all the pictures taken along with their time stamp.\
The images are displayed at a reduced size and by clicking on them you will see \
the clicked image at full size.\
The Changes:\
So far I have added an audio module to the App, to work as follow.\
when a motion is detected , picture taken and successfully saved a beep will be played.\
Eventually the storage unit will run out of room to store new pictures.\
In case this happens the Bug will play a warning sound 'Warning System Failure'\
every time the picture will be unsaved.\
(Please read the READ ME since I have disabled the audio for testing purposes)\
I also Added a new logo, a status view of the number of motions detected \
as well as making the web interface auto refresh itself every (60 seconds).\
"
HOMEPAGE = "http://buglabs.net/applications/DemoX1"

DEPENDS += "com.buglabs.bug.base com.buglabs.bug.menu com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.bug.module.camera com.buglabs.bug.module.motion com.buglabs.common com.buglabs.osgi com.buglabs.osgi.http com.sun.javax.servlet service-tracker "

PV = "10"

SRC_LINK = "http://buglabs.net/program_version/download/670"

APIVERSION = ""
