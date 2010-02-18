require qt4-embedded.inc
PR = "${INC_PR}.2"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -no-openvg"

require qt-${PV}.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"


