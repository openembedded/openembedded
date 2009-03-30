PR = "r4"
LICENSE = "GPLv2"

DEPENDS = "libvorbis libogg libxslt"

# The RDEPENDS line is a workaround to make sure
# icecast pulls in necessary library deps.
RDEPENDS = "libvorbis libogg libxslt"

SRC_URI = "http://downloads.us.xiph.org/releases/icecast/${PN}-${PV}.tar.gz"

# disable yp as curl cannot be configured
EXTRA_OECONF = "--disable-yp --with-ogg=${STAGING_LIBDIR} --with-vorbis=${STAGING_LIBDIR}"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

