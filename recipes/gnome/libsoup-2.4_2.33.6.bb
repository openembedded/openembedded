DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "libproxy glib-2.0 gnutls libxml2 sqlite3 gnome-keyring"

inherit gnome

# Need too new glib-2.0
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNOME_MIRROR}/libsoup/${@gnome_verdir("${PV}")}/libsoup-${PV}.tar.bz2;name=libsoup"
SRC_URI[libsoup.md5sum] = "3a7219057d289dd7dcdd67681d27eebe"
SRC_URI[libsoup.sha256sum] = "988f7897fe125a77a5946b2fd6d47d7374fd94a1406e810482cfff6a52a6a923"

S = "${WORKDIR}/libsoup-${PV}"

PACKAGES =+ "libsoup-gnome"
FILES_libsoup-gnome = "${libdir}/libsoup-gnome*.so.*"
FILES_${PN} = "${libdir}/libsoup-2*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"
