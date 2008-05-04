DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gnutls libxml2"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/2.4/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
        cp ${PKG_CONFIG_DIR}/libsoup.pc ${PKG_CONFIG_DIR}/libsoup-2.4.pc
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"
