DESCRIPTION = "Freetype fontfactory plugin"
SECTION = "opie/fontfactories"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "freetype"
APPNAME = "freetypefactory"

S = "${WORKDIR}/freetype"

inherit opie

EXTRA_QMAKEVARS_POST = "INCLUDEPATH+=${STAGING_INCDIR}/freetype2"
