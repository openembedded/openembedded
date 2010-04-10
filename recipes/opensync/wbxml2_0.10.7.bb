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

SRC_URI[md5sum] = "ef3e66df3c4223ce5ce0a70ded5c5221"
SRC_URI[sha256sum] = "24112231e70c21f90348cefeea362de36aa7bace4088355efcbf4efe0dd242d0"
