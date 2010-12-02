require bug-app.inc

DESCRIPTION = "This application was designed to demonstrate how BUGs may communicate with one another over a network.  YAPOC.  Yet Another Proof Of Concept.\
What it requires:\
Three BUGs, BUG1 with LCD and Motion modules, BUG2 with Camera, BUG3 with Camera.  If you are using this application with virtual BUGs, you can launch multiple virtual bugs by modifying the HTTP Port for each of the BUGs (in SDK, Run->Open Run Dialog->Virtual BUG).  If this is for the virtual BUG you will also need to modify the BUG IPs to localhost (lines 50 & 51 in the ServiceTracker) and change the http request ports accordingly.  \
\
What it does:\
BUG1 will begin detecting motion when Hotkey1 is pressed.  When it detects motion, it will attempt to connect to BUG2 to snap a picture.  If for some reason BUG2 is offline or is missing its camera module, it will take a picture with BUG3.\
What it has:\
It comes with Apache's httpclient jars.  httpclient makes timeout specification for http requests really easy.  The standard java libraries will wait up to 5 minutes for a request.  \
"
HOMEPAGE = "http://buglabs.net/applications/NetworkedBUGApp"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/243"

APIVERSION = ""

BROKEN = "1"
