DESCRIPTION = "Datebook plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-today"

APPNAME = "todaydatebookplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/today/plugins/datebook "

S = "${WORKDIR}/datebook"

inherit opie

