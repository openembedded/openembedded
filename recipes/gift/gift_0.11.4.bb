SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libvorbis libogg"
DESCRIPTION = "giFT is a framework for bridging multiple \
backend peer-to-peer protocols and the user interface \
associated with them."
FILES_gift_append = " ${datadir}/giFT"

SRC_URI = "${SOURCEFORGE_MIRROR}/gift/gift-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-vorbis-libraries=${STAGING_LIBDIR} \
		--with-vorbis-includes=${STAGING_INCDIR}"

SRC_URI[md5sum] = "decc82159c6723be999b1306a808077f"
SRC_URI[sha256sum] = "68149059b807b2fac505e376c18320e64104fbe0190e359f98059e73a63693dc"
