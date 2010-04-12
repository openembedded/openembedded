require qt4-x11-free.inc
PR = "${INC_PR}.6"

QT_GLFLAGS = "-opengl es2 -no-openvg  -depths 16,24,32 "

require qt-${PV}.inc

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"

FILESPATHPKG .= ":qt4-x11-free-${PV}:qt4-x11-free"

DEPENDS += "virtual/egl"
PROVIDES += "qt4-x11-free"


