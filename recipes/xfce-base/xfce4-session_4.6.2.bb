DESCRIPTION = "xfce4-session is a session manager for Xfce 4 Desktop Environment"
DEPENDS = "libxfcegui4 libxfce4util dbus iceauth xfce-utils"
SECTION = "x11"

PR = "r0"

inherit xfce46

RDEPENDS_${PN} = "iceauth xfce-utils xinit dbus-x11"

FILES_${PN} += "${libdir}/xfce4/splash/engines/*.so"
FILES_${PN} += "${datadir}/xfce4/tips/*"
FILES_${PN} += "${datadir}/themes/Default/balou/*"

FILES_${PN}-dbg += "${libdir}/xfce4/splash/engines/.debug/*.so"
FILES_${PN}-dbg += "${libdir}/xfce4/splash/engines/.debug/*.a"

FILES_${PN}-dev += "${libdir}/xfce4/splash/engines/*.la"
FILES_${PN}-dev += "${libdir}/xfce4/splash/engines/*.a"

SRC_URI[md5sum] = "9d9890130e45e0e9476591ed9ba2c9d5"
SRC_URI[sha256sum] = "725e269254c34c530acb670f5ccd0fd69b57cbe9f2176abd8499fc5d6dcd30a8"
