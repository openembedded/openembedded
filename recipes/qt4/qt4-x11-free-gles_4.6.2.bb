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



SRC_URI[md5sum] = "eb651ee4b157c01696aa56777fc6e0e5"
SRC_URI[sha256sum] = "176f51ddb06dce67ab4b2efc6b327dc21ed8f764c5d97acc15ff1f907c2affae"
