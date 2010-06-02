DESCRIPTION = "Opie datebook birthday plugin"
SECTION = "opie/datebook"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "opie-datebook"
APPNAME = "birthdayplugin"

S = "${WORKDIR}/birthday"

inherit opie
