DESCRIPTION = "Freetype fontfactory plugin"
SECTION = "opie/fontfactories"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "freetype"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "freetypefactory"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/freetype"
S = "${WORKDIR}/freetype"

inherit opie

EXTRA_QMAKEVARS_POST = "INCLUDEPATH+=${STAGING_INCDIR}/freetype2"
