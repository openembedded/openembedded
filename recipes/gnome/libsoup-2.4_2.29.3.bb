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

SRC_URI[md5sum] = "f2b0f1bfd1657b74f6dfbec20bb94e08"
SRC_URI[sha256sum] = "4b38450a74b569a63bd36a793de25dd84570e47948bf63889c4b808c9f18cf3e"
