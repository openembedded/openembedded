require bug-app.inc

DESCRIPTION = "BUGdash is a web-based admin tool for managing software and viewing settings on BUG."
HOMEPAGE = "http://buglabs.net/applications/bugdash2"

DEPENDS += "com.buglabs.bug.base com.buglabs.common com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.nmea com.buglabs.bug.program com.buglabs.osgi.shell felix"

PV = "14"

SRC_LINK = "http://www.buglabs.net/program_version/download/1360"
JARFILENAME = "bugdash2.jar"
FILES_${PN} += "/usr/share/java/apps/bugdash2.jar"
APIVERSION = "2.0.2"
