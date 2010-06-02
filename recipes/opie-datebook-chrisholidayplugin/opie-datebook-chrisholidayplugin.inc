DESCRIPTION = "Opie datebook christian holidays plugin"
SECTION = "opie/datebook"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "opie-datebook"
APPNAME = "chrisholidayplugin"

S = "${WORKDIR}/christian"

inherit opie
