DESCRIPTION = "Phone input method manager module"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ ptim-headers libiac"
PV = "0.1+svn-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/ptim;module=immanager \
           file://gtkmodule-location.patch;patch=1;pnum=0"

S = "${WORKDIR}/immanager"

FILES_${PN} += "${libdir}/gtk-2.0/*/immodules/*.so ${libdir}/gtk-2.0/*/immodules/ptim"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/immodules/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/immodules/*.la"

do_stage () {
    autotools_stage_all
}