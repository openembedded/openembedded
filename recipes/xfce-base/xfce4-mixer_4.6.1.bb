# xfce-mixer-plugin OE build file

DESCRIPTION="XFCE panel mixer plugin"
DEPENDS="libwnck xfce4-panel"
RDEPENDS="xfce4-panel"
SECTION = "x11"
PR = "r2"

inherit xfce46

FILES_${PN} += "${datadir}/xfce4/panel-plugins/*.desktop"
FILES_${PN} += "${libdir}/xfce4/modules/libxfce4mixer.so"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"
