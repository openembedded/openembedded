DEFAULT_PREFERENCE = "-1"

require qt4-x11-free.inc
PR = "${INC_PR}.7"

QT_GLFLAGS = "-opengl es2 -depths 16,24,32 "

require qt-${PV}.inc

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"

FILESPATHPKG .= ":qt4-x11-free-${PV}:qt4-x11-free"

DEPENDS += "virtual/egl"
require recipes/egl/egl.inc
PROVIDES += "qt4-x11-free"
