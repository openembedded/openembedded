require bug-app.inc

DESCRIPTION = "App designed for the mother BUG\
What it does:\
At the touch of a button, App begins listening for motion events.\
If it is within the time of 6PM-9AM EDT:\
it will twitter about motion events.\
It will post a photo to twitxr when the motion event occured.\
\
Note: if you download this app, you'll need to change a few variables for YOUR account information.  The defaults are invalid account credentials so it won't work out of the box.\
See http://twitxr.com/motherbug for the twitxr motherbug account  and http://twitter.com/motherbug for the motherbug app twitter feed with info about motion events.\
Forthcoming for this app, remote customizability through the WebService interface.\
\
--------------------------------------\
Please feel free to email me at john [at] buglabs.net for information. Or check out Bug Labs on IRC: irc://irc.freenode.net/buglabs.\
"
HOMEPAGE = "http://buglabs.net/applications/MotherBUGTweetNTwitch"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/233"

APIVERSION = ""

BROKEN = "1"
