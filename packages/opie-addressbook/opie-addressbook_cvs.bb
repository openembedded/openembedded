DESCRIPTION = "Contacts"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "addressbook"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/addressbook \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/addressbook"

inherit opie

# FILES plugins/application/libaddressbook.so* bin/addressbook apps/1Pim/addressbook.desktop
