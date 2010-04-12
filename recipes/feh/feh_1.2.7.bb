SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
LICENSE = "MIT"
DEPENDS = "virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "http://linuxbrit.co.uk/downloads/feh-${PV}.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/feh-${PV}"

inherit autotools

SRC_URI[md5sum] = "a25a4ace719a69bab1df5929ad7b9716"
SRC_URI[sha256sum] = "08db3709424613680c0400c6ab0bd28f623928e5f33f4d7469ecd71328fbf1c2"
