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

SRC_URI[md5sum] = "46616e5897a51b3935d1c683a410a0d9"
SRC_URI[sha256sum] = "e0a4b8e21a7c8efbc4b48c53403edbe367681052d8f3079d170c0b692c735d36"
