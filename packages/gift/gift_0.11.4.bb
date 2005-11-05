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
