DESCRIPTION = "A datebook/appointment manager"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-pics"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "datebook"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/datebook \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdatebook.so* bin/datebook apps/1Pim/datebook.desktop
