DESCRIPTION = "Datebook plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-today"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "todaydatebookplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/today/plugins/datebook "

S = "${WORKDIR}/datebook"

inherit opie

