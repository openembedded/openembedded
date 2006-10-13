DESCRIPTION = "Contacts"
SECTION = "opie/pim"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
APPNAME = "addressbook"


S = "${WORKDIR}/addressbook"

inherit opie

# FILES plugins/application/libaddressbook.so* bin/addressbook apps/1Pim/addressbook.desktop
