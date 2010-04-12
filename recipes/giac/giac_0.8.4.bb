DESCRIPTION = "A free computer algebra system"
HOMEPAGE = "http://www-fourier.ujf-grenoble.fr/~parisse/giac.html"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fltk gmp mpfr gsl"

SRC_URI = "ftp://ftp-fourier.ujf-grenoble.fr/xcas/giac-${PV}.tar.gz"

inherit autotools

PARALLEL_MAKE = ""

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
	sed -i -e s:doc::g ${S}/Makefile.am
	oe_runconf
	sed -i -e s:doc::g ${S}/Makefile
}

do_install () {
        oe_runmake prefix="${D}${prefix}" \
                bindir="${D}${bindir}" \
                libdir="${D}${libdir}" \
                includedir="${D}${includedir}" \
                install
}

PACKAGES += " libgiac libxcas"

FILES_${PN} = "${bindir} \
               ${datadir}/${PN} \
               ${datadir}/application* \
               ${datadir}/pixmaps \
"

FILES_libgiac = "${libdir}/libg*.so.*"
FILES_libxcas = "${libdir}/libx*.so.*"

SRC_URI[md5sum] = "c0bdb493cfef3dd058cc3750101a4f47"
SRC_URI[sha256sum] = "354923541221670d48ea2d713abd3fcad94e7f0d220ac9d53e9bcee0eda6ed4a"
