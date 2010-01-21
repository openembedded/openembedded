DESCRIPTION = "Lightweight fltk2 browser, with support for SSL, tabs and much more..."
HOMEPAGE = "http://www.dillo.org"
SECTION = "x11/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fltk2 libpng openssl"
RDEPENDS = "fltk2-images"
SRC_URI="http://www.dillo.org/download/dillo-${PV}.tar.bz2 \
         file://dillo.desktop \
         file://dillo.png"
PR = "r2"

S = "${WORKDIR}/dillo-${PV}/"

inherit autotools pkgconfig

FILES_${PN} += " /usr/lib/dillo/ /usr/bin/dpid /usr/bin/dpidc "
FILES_${PN}-dbg += " ${libdir}/dillo/dpi/*/.debug/"


EXTRA_OECONF = "--enable-ipv6"

do_install_append() {
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/dillo.desktop ${D}${datadir}/applications/dillo.desktop
        install -m 0644 ${WORKDIR}/dillo.png ${D}${datadir}/pixmaps/dillo.png
}
