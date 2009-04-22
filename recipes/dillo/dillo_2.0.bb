SECTION = "x11/network"
DESCRIPTION = "Lightweight gtk+2 browser."
LICENSE = "GPL"
DEPENDS = "fltk2"
RDEPENDS = "gdk-pixbuf-loader-xpm fltk2"
SRC_URI="http://www.dillo.org/download/dillo-${PV}.tar.bz2 \
         file://dillo.desktop \
         file://dillo.png \
         file://dillorc"
PR="r1"

PRIORITY = "optional"

S = "${WORKDIR}/dillo-${PV}/"

inherit autotools pkgconfig

EXTRA_EOCONF+="--enable-ssl"

do_compile_prepend() {
	sed -i "s|#undef ENABLE_SSL||" ${S}/dpi/https.c
}
	     
do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/dillo.desktop ${D}${datadir}/applications/dillo.desktop
	install -m 0644 ${WORKDIR}/dillo.png ${D}${datadir}/pixmaps/dillo.png
	install -m 0755 ${S}/src/dillo ${D}${bindir}/dillo
	install -m 0644 ${WORKDIR}/dillorc ${D}${sysconfdir}/dillorc
}
