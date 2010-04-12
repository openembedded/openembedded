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


SRC_URI[md5sum] = "ff516b3ccd2bcc31e68f460cd316093f"
SRC_URI[sha256sum] = "4742b38fc55b6373895a7c0a35baed49a848fec99f5e8538e3f0157383d0b3f0"
