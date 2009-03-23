SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
LICENSE = "MIT"
DEPENDS = "virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "http://linuxbrit.co.uk/downloads/feh-${PV}.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/feh-${PV}"

inherit autotools
