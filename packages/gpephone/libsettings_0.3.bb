DESCRIPTION = "G(PE)^2 settings API library"
SECTION = "gpe/libs"
PRIORITY = "required"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 gconf-dbus"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${PN}/${P}.tar.gz"

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"

do_stage () {
    autotools_stage_all
}
