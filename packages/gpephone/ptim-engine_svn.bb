DESCRIPTION = "Phone input method engine"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ ptim-headers"
PV = "0.1+svnr-${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/ptim;module=imengine"

S = "${WORKDIR}/imengine"

FILES_${PN} += " ${libdir}/gtk-2.0/*/immodules/ptim/engine/*.so ${libdir}/gtk-2.0/*/immodules/ptim/pydatabase/*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/ptim/engine/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/ptim/engine/*.la"

do_stage () {
    autotools_stage_all
}