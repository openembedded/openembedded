DESCRIPTION = "XFCE theme for GTK"
DEPENDS += "gtk+"
SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"
