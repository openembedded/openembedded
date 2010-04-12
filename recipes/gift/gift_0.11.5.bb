SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libvorbis libogg libtool"
DESCRIPTION = "giFT is a framework for bridging multiple \
backend peer-to-peer protocols and the user interface \
associated with them."
PR ="r1"
FILES_gift_append = " ${datadir}/giFT"

SRC_URI = "${SOURCEFORGE_MIRROR}/gift/gift-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-vorbis-libraries=${STAGING_LIBDIR} \
		--with-vorbis-includes=${STAGING_INCDIR}"

SRC_URI[md5sum] = "f492b6e3607aed801b77657f3808f5c1"
SRC_URI[sha256sum] = "3d3013fb5648b6060202a63c13c160899da8baf756140c7fd8f4ed432b40fdd2"
