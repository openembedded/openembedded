LICENSE = "GPL"
DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/2.2/${PN}-${PV}.tar.bz2"
DEPENDS = "glib-2.0 gnutls libxml2"

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"

do_stage() {
	autotools_stage_all
	ln -s ${STAGING_DATADIR}/pkgconfig/libsoup.pc ${STAGING_DATADIR}/pkgconfig/libsoup-2.2.pc
}

SRC_URI[md5sum] = "2704961ca2b9597819f21b40d4a0e0aa"
SRC_URI[sha256sum] = "e69f4cc9baee9be87400371cbdca1cb03428394c624640e64397089d090dbf0d"
