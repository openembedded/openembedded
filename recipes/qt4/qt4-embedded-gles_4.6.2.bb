require qt4-embedded.inc
PR = "${INC_PR}.7"

PROVIDES += "qt4-embedded"
QT_GLFLAGS = "-opengl es2 -no-openvg  -depths 16,24,32  -plugin-gfx-powervr"

require qt-${PV}.inc


FILESPATHPKG .= ":qt4-embedded-${PV}:qt4-embedded"

DEPENDS += "virtual/egl"



SRC_URI[md5sum] = "eb651ee4b157c01696aa56777fc6e0e5"
SRC_URI[sha256sum] = "176f51ddb06dce67ab4b2efc6b327dc21ed8f764c5d97acc15ff1f907c2affae"
