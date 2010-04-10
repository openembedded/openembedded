DESCRIPTION = "XFCE theme for GTK"
DEPENDS += "gtk+"
SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"

SRC_URI[md5sum] = "e836705d2933d0a77c6628285e10d982"
SRC_URI[sha256sum] = "c817050b2526ac107e1971d344aa20e06b98b80b60c912e83fa96d7804b4e8ca"
