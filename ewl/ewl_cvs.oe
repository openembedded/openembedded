DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the Evas canvas."
SECTION = "e/libs"
DEPENDS = "edb eet evas ecore etox edje"
PV = "${CVSDATE}"
PR = "r2"

LICENSE = "MIT"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/ewl \
           file://no-x-test.patch;patch=1"
S = "${WORKDIR}/ewl"

inherit autotools binconfig

do_stage () {
	oe_libinstall -C src libewl ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/Ewl.h ${STAGING_INCDIR}/
}

PACKAGES += "ewl-examples"

FILES_${PN} = "${libdir}/libewl*.so*"
FILES_${PN}-dev += "${bindir}/ewl-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/ewl* ${bindir}/edje_ls ${datadir}"

