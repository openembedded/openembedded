HOMEPAGE = "http://bytesex.org/fbi.html"
DESCRIPTION = "frame buffer image viewer"
DEPENDS = "jpeg"

SRC_URI = "http://dl.bytesex.org/releases/fbida/fbi_${PV}.tar.gz"

inherit autotools

CFLAGS_append = " ${LDFLAGS}"
EXTRA_OECONF = "--disable-magick --without-x"
