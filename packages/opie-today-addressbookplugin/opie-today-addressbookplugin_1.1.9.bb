DESCRIPTION = "Addressbook plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-today"

APPNAME="todayaddressbookplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/today/plugins/addressbook "

S = "${WORKDIR}/addressbook"

inherit opie

