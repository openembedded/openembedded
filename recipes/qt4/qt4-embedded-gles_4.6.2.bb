require qt4-embedded.inc
PR = "${INC_PR}.7"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -no-openvg  -depths 16,24,32  -plugin-gfx-powervr"

require qt-${PV}.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"


