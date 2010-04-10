DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "libproxy glib-2.0 gnutls libxml2 sqlite3 gnome-keyring"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/libsoup/${@gnome_verdir("${PV}")}/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

PACKAGES =+ "libsoup-gnome"
FILES_libsoup-gnome = "${libdir}/libsoup-gnome*.so.*"
FILES_${PN} = "${libdir}/libsoup-2*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"

SRC_URI[md5sum] = "7ce3eac3d862c963290e2042c2c1c361"
SRC_URI[sha256sum] = "3718610c6b6ce118c1f61f9dc0e98a439dbfd7bc7ef3f7ce541617fec8fbce2f"
