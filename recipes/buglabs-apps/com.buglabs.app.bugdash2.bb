require bug-app.inc

DESCRIPTION = "A prototype application launcher."
HOMEPAGE = "http://buglabs.net/applications/AppUI"

DEPENDS += "com.buglabs.bug.base com.buglabs.common com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.nmea com.buglabs.bug.program com.buglabs.osgi.shell felix"

PV = "8"

SRC_LINK = "http://www.buglabs.net/program_version/download/1346"
JARFILENAME = "bugdash2.jar"
FILES_${PN} += "/usr/share/java/apps/bugdash2.jar"
APIVERSION = ""
