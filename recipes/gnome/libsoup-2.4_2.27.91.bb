DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "libproxy glib-2.0 gnutls libxml2 sqlite3 gnome-keyring"

PR = "r1"

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

SRC_URI[md5sum] = "58e5518a483fbef0b72f142e63f43e9f"
SRC_URI[sha256sum] = "b39fd86e555cc530ec587db8860b084e95555e044c0cf8b213e636aff043e4f3"
