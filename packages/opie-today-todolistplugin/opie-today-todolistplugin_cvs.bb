DESCRIPTION = "Todo list plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-today"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "todaytodolistplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/today/plugins/todolist "

S = "${WORKDIR}/todolist"

inherit opie

