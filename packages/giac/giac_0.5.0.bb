SECTION = "console/utils"
DESCRIPTION = "A free computer algebra system"
HOMEPAGE = "http://www-fourier.ujf-grenoble.fr/~parisse/giac.html"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fltk gmp mpfr gsl"
#          ntl pari"

SRC_URI = "ftp://ftp-fourier.ujf-grenoble.fr/xcas/giac-${PV}.tar.gz"

inherit autotools

PACKAGES += " lib${PN}"
FILES_${PN} = "${bindir} \
               ${datadir}/${PN}"
FILES_lib${PN} = "${libdir}"

# breaks the build...
#EXTRA_OECONF = "--enable-debug=no"

# skip autoreconf for now (fails due to improper local macros)
do_configure() {
	oe_runconf
}

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		install

	# put the docs where they belong
	# might need further investigation in case giac needs
	# them in the original place
	install -d ${D}${docdir}
	mv ${D}${datadir}/${PN}/doc ${D}${docdir}/${PN}
}
