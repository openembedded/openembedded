DEFAULT_PREFERENCE = "-1"

require qt4-embedded.inc

PR = "${INC_PR}.10"

QT_CONFIG_FLAGS_append_armv6 = " -no-neon "

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -depths 16,24,32  -plugin-gfx-powervr"
 
FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

require qt-${PV}.inc

QT_CONFIG_FLAGS += " \
 -exceptions \
"

