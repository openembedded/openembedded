DESCRIPTION = "XFCE theme for GTK"
DEPENDS += "gtk+"

inherit xfce
XFCE_VERSION = 4.4.2

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"

SRC_URI[md5sum] = "00eb6a62defe6867d28a18569b96d151"
SRC_URI[sha256sum] = "6fecdb590fa024db698de9027314c1be044f28feab9850f592aa60c3a79ede78"
