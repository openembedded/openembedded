SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "MIT"
DEPENDS = "imlib2 giblib jpeg libx11 libxext libxt"

SRC_URI = "http://linuxbrit.co.uk/downloads/feh-${PV}.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/feh-${PV}"

inherit autotools
