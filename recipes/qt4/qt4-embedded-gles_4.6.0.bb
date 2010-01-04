require qt4-embedded.inc
PR = "${INC_PR}.1"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -openvg"

require qt-4.6.0.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"


