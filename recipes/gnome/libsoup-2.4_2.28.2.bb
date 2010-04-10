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

SRC_URI[md5sum] = "31d7ad416005eed4b78f07ac01b6b9f0"
SRC_URI[sha256sum] = "9dd1fce9a051f8176e35c263fcb59b10bf4ffb572b78ca23d1f7f266a0ec5300"
