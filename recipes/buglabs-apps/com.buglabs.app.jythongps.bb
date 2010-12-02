require bug-app.inc

DESCRIPTION = "SDK Build 248\
Virtual BUG\
JythonGps is the first attempt at using Python to write a BUG application. The application itself is very simple, it gets information from the GPS when the first button is pressed and displays it on the two-line LED display on the BUGbase. The purpose of this application was to lay out a path for getting BUG Apps written in Python. There are potentially many approaches, but this was the one I took. The best way to understand how everything works is to download it and take a look at the code.\
A detailed description can be found here.  The source code has a lot of comments as well.\
This application includes the Jython jar.  The license for this jar is here."
HOMEPAGE = "http://buglabs.net/applications/JythonGPS"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/43"

APIVERSION = ""

BROKEN = "1"
