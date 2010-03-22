DESCRIPTION = "Xfce panel plugins for power management."
DEPENDS = "libxfce4util libxfcegui4 libnotify xfconf xfce4-panel"
RDEPENDS = "libxfce4util libxfcegui4 libnotify xfce4-panel"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://archive.xfce.org/src/apps/${PN}/0.8/${PN}-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/xfce4/panel-plugins/*.desktop"

FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"
