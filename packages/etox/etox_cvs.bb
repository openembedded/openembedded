DESCRIPTION = "Etox is a type setting and text layout library based on Evas. \
Etox helps you when it comes to displaying, moving, resizing, layering, \
clipping, aligning and coloring fonts in different styles, and more."
SECTION = "e/libs"
DEPENDS = "edb evas ecore"
PV = "${CVSDATE}"
PR = "r3"
LICENSE = "MIT"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/etox"
S = "${WORKDIR}/etox"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src libetox ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/Etox.h ${STAGING_INCDIR}/
}

PACKAGES += "etox-examples"

FILES_${PN} = "${libdir}/libetox*.so*"
FILES_${PN}-dev += "${bindir}/etox-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/etox* ${datadir}"
