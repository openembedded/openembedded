DESCRIPTION = "Libsyncml is an implementation of the SyncML protocol."
HOMEPAGE = "https://libsyncml.opensync.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "libxml2 glib-2.0"
RRECOMMENDS = "wbxml2 openobex libsoup"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libsyncml/libsyncml-${PV}.tar.gz \
           "

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

SRC_URI[md5sum] = "84879ed7cb94618530fbcb801a1a4f95"
SRC_URI[sha256sum] = "05d6513637adb1300a3a58b6e29d53ab6373c8f370807d0d925bae72b2920e53"
