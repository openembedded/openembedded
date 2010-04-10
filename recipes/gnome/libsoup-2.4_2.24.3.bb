DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gnutls libxml2"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/libsoup/${@gnome_verdir("${PV}")}/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"

SRC_URI[md5sum] = "118967f097a7e1e9d5023f1f06e0b65a"
SRC_URI[sha256sum] = "30055988d990f0f4db4dcffd5088115f1065a6fd7c22b555686449628375376b"
