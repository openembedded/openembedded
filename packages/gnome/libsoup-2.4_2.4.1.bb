DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gnutls libxml2"

PR = "r1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/2.4/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"
