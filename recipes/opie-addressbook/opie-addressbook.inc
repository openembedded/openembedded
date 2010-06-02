DESCRIPTION = "Contacts"
SECTION = "opie/pim"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "opie-pics"
APPNAME = "addressbook"


S = "${WORKDIR}/addressbook"

inherit opie

# FILES plugins/application/libaddressbook.so* bin/addressbook apps/1Pim/addressbook.desktop
