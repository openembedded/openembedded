require qt4-embedded.inc
PR = "${INC_PR}.1"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -openvg"

require qt-4.6.0.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"



SRC_URI[md5sum] = "2a7b5126f2450d8525af355fc4c12ad6"
SRC_URI[sha256sum] = "55259c813324f6383cbd441aa2f23e01c320b6d63fbe3b5d52a7715055d28589"
