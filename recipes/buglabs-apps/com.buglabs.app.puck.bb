require bug-app.inc

DESCRIPTION = "Notes:\
You must be using the latest rootfs and the integration build of Dragonfly (>= 1.0.0.1621) for this application to work.\
The application is configured for the BUGview module in slot 0 (top left-hand side slot) and BUGmotion in slot 1 (top-right).\
\
v1.0.6 01/27/2010\
Fixed an orientation issue with pucks movement due to switching java apps back to slot 0/2. Also make puck move a bit faster. Please note LCD should be in slot 0 and Motion in slot 1\
v1.0.1 06/27/2008\
Made it scroll a bit more smoothly. AFAIK, we don't have access to double buffering, like you do in Swing, so if anyone has any suggestions on how to make the ball scroll more smoothly, please share.\
v1.0.0 06/26/2008:\
First pass at using the accelerometer to move something around the screen when you tilt the bug. It's a bit jerky right now, as I wasn't sure how best to implement smooth scrolling. Once I've gotten that figured out I'd like to make it into a game, perhaps drawing inspiration from the balance games on the Wii Fit that you have to do during a fitness test (not the fancy ones you do in training).\
Thanks to Angel for BUGLevel, an excelllent source of accelerometer insight, and Brian for his screen test app."
HOMEPAGE = "http://buglabs.net/applications/Puck"

DEPENDS += "com.buglabs.bug.base com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.osgi service-tracker "

PV = "6"

SRC_LINK = "http://buglabs.net/program_version/download/1075"

APIVERSION = "1.4.3"
