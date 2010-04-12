DESCRIPTION = "xfce4-session is a session manager for Xfce 4 Desktop  Environment"
DEPENDS = "libxfcegui4 libxfce4util dbus iceauth xfce-utils"
SECTION = "x11"

PR = "r4"

inherit xfce46

RDEPENDS_${PN} = "iceauth xfce-utils xinit dbus-x11"

FILES_${PN} += "${libdir}/xfce4/splash/engines/*.so"
FILES_${PN} += "${datadir}/xfce4/tips/*"
FILES_${PN} += "${datadir}/themes/Default/balou/*"

FILES_${PN}-dbg += "${libdir}/xfce4/splash/engines/.debug/*.so"
FILES_${PN}-dbg += "${libdir}/xfce4/splash/engines/.debug/*.a"

FILES_${PN}-dev += "${libdir}/xfce4/splash/engines/*.la"
FILES_${PN}-dev += "${libdir}/xfce4/splash/engines/*.a"

SRC_URI[md5sum] = "7628be41ed3511a20cff5673d9d39858"
SRC_URI[sha256sum] = "feed3f9053b83233697223a20f95ca0ad6efe9fedffcc098e4935a425e8f9f0e"
