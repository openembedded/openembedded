SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
LICENSE = "MIT"
DEPENDS = "virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "http://linuxbrit.co.uk/downloads/feh-${PV}.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/feh-${PV}"

inherit autotools

SRC_URI[md5sum] = "6d40889465181de51bb26fbbe57fbfac"
SRC_URI[sha256sum] = "281cec4cec724b53ba501718e8010bbff0ef49415649e4e7fe6431ec62ebea7d"
