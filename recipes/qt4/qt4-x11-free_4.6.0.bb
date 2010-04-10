require qt4-x11-free.inc
PR = "${INC_PR}.1"

require qt-4.6.0.inc

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"



SRC_URI[md5sum] = "2a7b5126f2450d8525af355fc4c12ad6"
SRC_URI[sha256sum] = "55259c813324f6383cbd441aa2f23e01c320b6d63fbe3b5d52a7715055d28589"
