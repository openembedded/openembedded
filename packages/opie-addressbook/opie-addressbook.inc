DESCRIPTION = "Contacts"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
APPNAME = "addressbook"


S = "${WORKDIR}/addressbook"

inherit opie

# FILES plugins/application/libaddressbook.so* bin/addressbook apps/1Pim/addressbook.desktop
