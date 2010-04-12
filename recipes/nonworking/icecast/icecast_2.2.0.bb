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


SRC_URI[md5sum] = "7958347af55651384298828175e32dcf"
SRC_URI[sha256sum] = "c95ee1d68c287f654e6ee1d3416a91c058531232d6f08ff6ed156376f997a41d"
