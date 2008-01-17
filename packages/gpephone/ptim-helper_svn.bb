DESCRIPTION = "Phone input method helper module"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ ptim-headers"
PV = "0.1+svnr-${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/ptim;module=imhelper"

S = "${WORKDIR}/imhelper"

FILES_${PN} += " ${libdir}/gtk-2.0/*/immodules/ptim/helper/*.so ${libdir}/gtk-2.0/*/immodules/ptim/pixmaps/*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/ptim/helper/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/ptim/helper/*.la"

do_stage () {
    autotools_stage_all
}