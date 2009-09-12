require xorg-lib-common.inc

DESCRIPTION = "X11 Resize and Rotate extension library"
LICENSE = "BSD-X"
DEPENDS += "randrproto-native libxrender-native libxext-native"
PR = "r0"
PE = "1"

inherit native

XORG_PN = "libXrandr"
