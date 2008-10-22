DESCRIPTION = "Phone input method helper module"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ ptim-headers"
PR = "r1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${P}/imhelper-${PV}.tar.bz2"

S = "${WORKDIR}/imhelper-${PV}"

FILES_${PN} += " ${libdir}/gtk-2.0/*/immodules/ptim/helper/*.so ${libdir}/gtk-2.0/*/immodules/ptim/pixmaps/*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/ptim/helper/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/ptim/helper/*.la"

do_stage () {
    autotools_stage_all
}

pkg_postinst_${PN}() {
    gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}

pkg_postrm_${PN}() {
    gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}
