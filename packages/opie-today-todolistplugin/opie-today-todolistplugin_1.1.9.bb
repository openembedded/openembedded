DESCRIPTION = "Todo list plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-today"

APPNAME = "todaytodolistplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/today/plugins/todolist "

S = "${WORKDIR}/todolist"

inherit opie

