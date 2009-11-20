DESCRIPTION = "WBXML parsing and encoding library."
HOMEPAGE = "http://libwbxml.opensync.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/libwbxml/libwbxml-${PV}.tar.gz \
           "

S = "${WORKDIR}/libwbxml-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE += " . -B${WORKDIR}/build "

PACKAGES += "${PN}-tools"

FILES_${PN}-tools = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"

do_build_prepend() {
	cd ${WORKDIR}/build
}

do_install_prepend() {
	cd ${WORKDIR}/build
}
