DESCRIPTION = "Calendar application for the Xfce Desktop  Environment"
DEPENDS = "libxfcegui4  exo xfce4-panel"
RDEPENDS = "xfce4-panel"
RREPLACES = "xfcalendar"

SECTION = "x11"
PR = "r3"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/apps/${PN}/${@'${PV}'[0:3]}/${PN}-${PV}.tar.bz2"

XFCE_VERSION = "4.6.1"

EXTRA_OECONF += " --disable-libxfce4mcs"


FILES_${PN} += "${datadir}/xfce4/panel-plugins/*.desktop \
                ${datadir}/dbus-1/services/* \
"

FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"
