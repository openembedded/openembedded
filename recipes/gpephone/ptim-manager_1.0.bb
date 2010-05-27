DESCRIPTION = "Phone input method manager module"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ ptim-headers libiac"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/ptim-manager-${PV}/immanager-${PV}.tar.bz2"

S = "${WORKDIR}/immanager-${PV}"

FILES_${PN} += "${libdir}/gtk-2.0/*/immodules/*.so ${libdir}/gtk-2.0/*/immodules/ptim"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/*.la"


do_install_append () {
	# That's evil... 
	install -m 644 ${S}/conf/imconfig ${D}/${libdir}/gtk-2.0/*/immodules/ptim
}


do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "cafd1d222ae30fa496e299950de19ae7"
SRC_URI[sha256sum] = "e8e5144314fd2cd13722835338105c0236bf3da4dbf383a6ce052574c1ba7230"
