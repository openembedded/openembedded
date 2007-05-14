DESCRIPTION = "XFCE theme for GTK"

inherit xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.1/src/gtk-xfce-engine-${PV}.tar.bz2"

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"
