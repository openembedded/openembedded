DESCRIPTION = "Phone input method engine"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ ptim-headers"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${P}/imengine-${PV}.tar.bz2"

S = "${WORKDIR}/imengine-${PV}"

FILES_${PN} += " ${libdir}/gtk-2.0/*/immodules/ptim/engine/*.so ${libdir}/gtk-2.0/*/immodules/ptim/pydatabase/*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/ptim/engine/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/ptim/engine/*.la"

do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "c6735cb4a8f5bc7da74001ca895fd174"
SRC_URI[sha256sum] = "3d733f8a1cfeb60b3a83a03340e80e7a23a5d3141f8958fad1441142817cc077"
