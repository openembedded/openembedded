# xfprint OE build file

DESCRIPTION="XFCE4 Print Manager"
SECTION = "x11/base"

PR = "r2"

DEPENDS="libxfcegui4"

inherit xfce46

FILES_${PN} += "${libdir}/xfce4/xfprint-plugins/*.so"
FILES_${PN}-dev += "${libdir}/xfce4/xfprint-plugins/*.a"

SRC_URI[md5sum] = "d92fca97a42816085080baf07a99a62e"
SRC_URI[sha256sum] = "be0cc5d149234c22dee69db5f8cbddebc46bc21a4f96fefdec21df36b2a15f17"
