require qt4-x11-free.inc
PR = "${INC_PR}.3"

QT_GLFLAGS = "-opengl es2 -openvg"

require qt-4.6.0.inc

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"

FILESPATHPKG .= ":qt4-x11-free-${PV}:qt4-x11-free"

DEPENDS += "virtual/egl"
PROVIDES += "qt4-x11-free"


