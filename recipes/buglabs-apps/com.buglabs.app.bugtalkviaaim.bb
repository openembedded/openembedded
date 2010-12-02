require bug-app.inc

DESCRIPTION = "Install this app and talk to your BUG via AIM! \
Sign up for your BUG's AIM screen name (http://products.aim.com/) and enter credential info in BUGtalkApp class. \
The app starts upon installation and can be stopped via AppUI.\
Once the app is running, use your favorite IM client to talk to your BUG. Type in *help* to see available commands. You can add new commands in BUGtalkApp.im method. \
Have fun! \
(image credit: http://www.clker.com/clipart-2312.html) "
HOMEPAGE = "http://buglabs.net/applications/BUGtalkViaAIM"

DEPENDS += "com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.bug.module.motion com.buglabs.common com.buglabs.osgi com.buglabs.osgi.cm com.buglabs.osgi.shell service-tracker "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/1162"

APIVERSION = ""
