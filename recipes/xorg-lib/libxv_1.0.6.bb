require xorg-lib-common.inc
DESCRIPTION = "X11 Video extension library"
LICENSE = "MIT-style"
DEPENDS += "libxext videoproto"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "e292445a64b63e918bbc8b6aae6391dd"
SRC_URI[archive.sha256sum] = "e20f8e594bb0f44f3fbd25996945730391d72acbe5eaac760429fd6579caf5ee"

XORG_PN = "libXv"
