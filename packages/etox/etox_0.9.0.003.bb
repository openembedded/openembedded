DESCRIPTION = "Etox is a type setting and text layout library based on Evas. \
Etox helps you when it comes to displaying, moving, resizing, layering, \
clipping, aligning and coloring fonts in different styles, and more."
SECTION = "e/libs"
DEPENDS = "edb evas ecore"
LICENSE = "MIT"
PR = "r0"

SRC_URI = "http://enlightenment.freedesktop.org/files/etox-${PV}.tar.gz"
S = "${WORKDIR}/etox-${PV}"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src libetox ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/Etox.h ${STAGING_INCDIR}/
}

PACKAGES += "etox-examples"

FILES_${PN} = "${libdir}/libetox*.so*"
FILES_${PN}-dev += "${bindir}/etox-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/etox* ${datadir}"
