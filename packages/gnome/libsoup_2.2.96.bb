LICENSE = "GPL"
DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/2.2/${PN}-${PV}.tar.bz2"
DEPENDS = "glib-2.0 gnutls libxml2"
MAINTAINER = "Chris Lord <chris@openedhand.com>"

inherit autotools pkgconfig

PACKAGES_DYNAMIC = "libsoup-2.2*"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"

do_stage() {
	autotools_stage_all
	ln -s ${STAGING_DATADIR}/pkgconfig/libsoup.pc ${STAGING_DATADIR}/pkgconfig/libsoup-2.2.pc
}
