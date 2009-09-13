DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "libproxy glib-2.0 gnutls libxml2 sqlite3"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/libsoup/${@gnome_verdir("${PV}")}/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libsoup-gnome"
FILES_libsoup-gnome = "${libdir}/libsoup-gnome*.so.*"
FILES_${PN} = "${libdir}/libsoup-2*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"
