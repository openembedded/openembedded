DESCRIPTION = "Xfce configuration daemon and utilities"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "libxfce4util"
RDEPENDS = "libxfce4util"

PR = "r1"

inherit xfce46

do_stage() {
autotools_stage_all
}

FILES_${PN} += "${datadir}/dbus-1/services/org.xfce.Xfconf.service"
