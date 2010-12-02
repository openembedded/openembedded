require bug-app.inc

DESCRIPTION = "TwitterBug is a simple proof of concept Twitter client that pulls the last 20 updates from your friends list and displays them on the BUGview.  It uses com.Ostermiller.util.Base64 to encode the username and password for Basic HTTP authentication and the built in XmlNode and XmlParser classes to parse and print the results.\
Updates:\
	4/30/08 - Check out Brian's updated version using his new SimpleRESTClient.  Nice and clean!\
	4/24/08 - Fixed text wrapping issue using a TextArea\
\
Future Plans:\
\
Make the UI not suck.\
Use BUGlocate to do some kind of geo-tweeting.  Perhaps an 'I am here' tweet with a link to google maps.\
Switch over to using com.buglabs.bug.program.Base64.\
"
HOMEPAGE = "http://buglabs.net/applications/TwitterBug"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/199"

APIVERSION = ""

BROKEN = "1"
