require xorg-app-common.inc

DESCRIPTION = "X Resize and Rotate extension command."
LICENSE= "BSD-X"

DEPENDS += " libxrandr libxrender virtual/libx11"
PE = "1"
PR = "r2"


SRC_URI[archive.md5sum] = "9e74e6919cf731ec10ce26fd6a4483fa"
SRC_URI[archive.sha256sum] = "7bf3bd3cf46a6a29e35b9dd1c8d3d14494be76da0d24c6ef5dab36974445004d"
