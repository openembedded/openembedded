DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
PRIORITY = "optional"
PROVIDES = "virtual/evas"
DEPENDS = "libpng jpeg edb eet freetype"

SRC_URI = "http://enlightenment.freedesktop.org/files/evas-${PV}.tar.gz \
           file://pkg.m4"
S = "${WORKDIR}/evas-${PV}"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "<override me>"

do_configure () {
	install -m 0644 ${WORKDIR}/pkg.m4 acinclude.m4
	autotools_do_configure
}

headers = "<override me>"

do_stage () {
	for i in ${headers}; do
		install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
	done
	oe_libinstall -C src/lib libevas ${STAGING_LIBDIR}/
}

PACKAGES += "evas-examples"

FILES_${PN} = "${libdir}/libevas*.so*"
FILES_${PN}-dev += "${bindir}/evas-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/evas_fb_test ${datadir}"
