DESCRIPTION = "'fortune' plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-today libqtaux2"
RDEPENDS = "fortune-mod opie-today"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "todayfortuneplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/todayplugins/fortune "
S = "${WORKDIR}/fortune"

inherit opie
