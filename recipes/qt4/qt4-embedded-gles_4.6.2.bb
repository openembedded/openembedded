require qt4-embedded.inc
PR = "${INC_PR}.3"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -no-openvg -plugin-gfx-linuxfb -plugin-gfx-powervr"

require qt-${PV}.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"


