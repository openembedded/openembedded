require bug-app.inc

DESCRIPTION = "This application is a gallery for The Cammotion application\
it currently lacks many features...see the version informations for more details\
HOWTO:\
* take pictures with Cammotion(they go into /home/root/.mplayer/screenshots/ )\
* use a web browser(I've only tested on firefox 3.x) and go to: http://10.10.10.10/BugGallery\
"
HOMEPAGE = "http://buglabs.net/applications/BugGallery"

DEPENDS += "com.buglabs.osgi.http com.buglabs.osgi service-tracker com.sun.javax.servlet com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/744"

APIVERSION = ""
