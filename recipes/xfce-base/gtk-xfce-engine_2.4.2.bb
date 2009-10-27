DESCRIPTION = "XFCE theme for GTK"
DEPENDS += "gtk+"

inherit xfce
XFCE_VERSION = 4.4.2

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"
