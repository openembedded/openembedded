DESCRIPTION = "A datebook/appointment manager"
SECTION = "opie/pim"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
APPNAME = "datebook"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdatebook.so* bin/datebook apps/1Pim/datebook.desktop
