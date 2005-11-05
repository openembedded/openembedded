DESCRIPTION = "'fortune' plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-today libqtaux2"
RDEPENDS = "fortune-mod opie-today"
APPNAME = "todayfortuneplugin"

S = "${WORKDIR}/fortune"

inherit opie
