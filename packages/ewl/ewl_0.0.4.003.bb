DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library based on the enlightenment foundation libraries."
SECTION = "e/libs"
DEPENDS = "edb eet evas ecore etox edje"
LICENSE = "MIT"
PR = "r0"

SRC_URI = "http://enlightenment.freedesktop.org/files/ewl-${PV}.tar.gz \
           file://fix-configure.patch;patch=1"
S = "${WORKDIR}/ewl-${PV}"

inherit autotools binconfig

do_stage () {
	oe_libinstall -C src libewl ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Ewl.h ${STAGING_INCDIR}/
}

PACKAGES += "ewl-examples"

FILES_${PN} = "${libdir}/libewl*.so*"
FILES_${PN}-dev += "${bindir}/ewl-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/ewl* ${bindir}/edje_ls ${datadir}"

