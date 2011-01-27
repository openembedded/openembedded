DESCRIPTION = "Xfce4 Desktop Manager"
SECTION = "x11/base"

DEPENDS = "virtual/libx11 exo libxfcegui4 xfce4-panel thunar gtk+"
RDEPENDS_${PN} = "libxfcegui4 libxml2 xfce4-panel thunar exo gtk+"
PR = "r1"

inherit xfce46

FILES_xfdesktop-backdrops = "${datadir}/xfce4/backdrops/*"
FILES_${PN} += "${libdir}/xfce4/panel-plugins/*.so \
                ${libdir}/xfce4/panel-plugins/xfce4-menu-plugin \
                ${datadir}/xfce4/panel-plugins/*.desktop"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug"

SRC_URI[md5sum] = "e800ea9fee7a5c5eaf2ae96e23a83e3a"
SRC_URI[sha256sum] = "cd760f95486ba3f1c6d0179bb10a4c21c99c1d459dd8265823fed85f7376a3fb"
