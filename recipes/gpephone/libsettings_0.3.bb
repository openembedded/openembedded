DESCRIPTION = "G(PE)^2 settings API library"
SECTION = "gpe/libs"
PRIORITY = "required"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 gconf-dbus"

inherit gpephone pkgconfig autotools

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"

do_stage () {
    autotools_stage_all
}
