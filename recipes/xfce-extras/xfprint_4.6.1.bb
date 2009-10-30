# xfprint OE build file

DESCRIPTION="XFCE4 Print Manager"
SECTION = "x11/base"

PR = "r2"

DEPENDS="libxfcegui4"

inherit xfce46

FILES_${PN} += "${libdir}/xfce4/xfprint-plugins/*.so"
FILES_${PN}-dev += "${libdir}/xfce4/xfprint-plugins/*.a"
