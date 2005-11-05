SECTION = "x11/utils"
DESCRIPTION = "gtk2 outliner written by Matthew Allum"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libxml2"

SRC_URI = "http://handhelds.org/~mallum/downloadables/figment/figment-${PV}.tar.gz"
S = "${WORKDIR}/figment-${PV}"

inherit autotools
