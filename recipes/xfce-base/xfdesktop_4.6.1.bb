DESCRIPTION = "XFCE4 Desktop Manager"
SECTION = "x11/base"

DEPENDS = "virtual/libx11 exo libxfcegui4 xfce4-panel thunar gtk+"
RDEPENDS = "libxfcegui4 libxml2 xfce4-panel thunar exo gtk+"
PR = "r2"

inherit xfce46

do_configure() { 
   oe_runconf
}

FILES_xfdesktop-backdrops = "${datadir}/xfce4/backdrops/*"
FILES_${PN} += "${libdir}/xfce4/panel-plugins/*.so \
                ${libdir}/xfce4/panel-plugins/xfce4-menu-plugin \
                ${datadir}/xfce4/panel-plugins/*.desktop"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug"

SRC_URI[md5sum] = "ae15cacc3e3834cca7238a8e1035c50d"
SRC_URI[sha256sum] = "22aa4a654798dcfa728a9c0056486f73ae87a51239950c8f85aedef488cd571a"
