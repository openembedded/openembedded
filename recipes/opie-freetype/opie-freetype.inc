DESCRIPTION = "Freetype fontfactory plugin"
SECTION = "opie/fontfactories"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "freetype opie-ttf-support"
RDEPENDS = "opie-ttf-support"
APPNAME = "freetypefactory"
APPTYPE = "plugin"

S = "${WORKDIR}/freetype"

inherit opie

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/freetype2"

DEBIAN_NOAUTONAME_opie-freetype = "1"
