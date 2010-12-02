require bug-app.inc

DESCRIPTION = "Requires: BUGView (LCD), BUGCam, BUGMotion (motion/accelerometer).\
What it does (updated): Snap a picture with Hotkey 1, it shows up on the LCD screen and writes it to file (fuse my SimpleCamera and kgilmer's ImageTest).  Repeat snapping pictures to your hearts content.  Hit Hotkey 2 to delete all the photos saved on the BUG.  You will get a popup window notifying you of the deletion, but no confirmation prompt..  Hit Hotkey 4 to switch into SlideShow mode.  Shake the BUG to increment through your photo history.  \
Known issues: I define 'shaking' rather crudely.  I may tighten this up, but it's a good start for people looking for how to define something like an AccelerationEvent.  Angel is working hard to provide some awesome MDACC functionality, but for now this is how it is.  ;D  Currently there's no way to go from SlideShow mode back into Snap mode.  I'm looking to change this too.\
\
--------------------------------------\
Please feel free to email me at john [at] buglabs.net for information. Or check out BUGLabs on IRC: irc://irc.freenode.net/buglabs ."
HOMEPAGE = "http://buglabs.net/applications/SnapAndShakeSlideShow"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.base com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion "

PV = "11"

SRC_LINK = "http://buglabs.net/program_version/download/386"

APIVERSION = ""
