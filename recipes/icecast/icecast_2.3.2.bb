DESCRIPTION = "Icecast streaming media server"
LICENSE = "GPLv2"

DEPENDS = "libvorbis libogg libtheora speex libxslt libxslt-native"

PR = "r2"

SRC_URI = "http://downloads.us.xiph.org/releases/icecast/${PN}-${PV}.tar.gz"

# disable curl
EXTRA_OECONF = " \
                --without-curl \
                --with-ogg=${STAGING_LIBDIR} \
                --with-vorbis=${STAGING_LIBDIR} \
                --with-theora=${STAGING_LIBDIR} \
                --with-speex=${STAGING_LIBDIR} \
               "

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

