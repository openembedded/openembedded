LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"

DEPENDS = "libsigc++-2.0"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/${PN}/${P}.tar.gz"

do_stage() {
    autotools_stage_all
    install -d ${STAGING_LIBDIR}
    install -d ${STAGING_INCDIR}/net6
    install -m 644 inc/*.hpp ${STAGING_INCDIR}/net6
    install -m 755 .libs/*so* ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "8a551a2d9785b2b0ed431bb9eeb6cfd6"
SRC_URI[sha256sum] = "ccdf8bfec6098b9da9a82c8d3a4d85266a5c2fd8e0240bb9448448ea39f3a68a"
