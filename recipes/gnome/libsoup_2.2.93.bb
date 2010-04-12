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

SRC_URI[md5sum] = "08f9c570a4331778da95c0bc317f6bf4"
SRC_URI[sha256sum] = "9196f6bd888ade327cb475e95187ebd323594b13ddde7c2202e4e5cb16920a19"
