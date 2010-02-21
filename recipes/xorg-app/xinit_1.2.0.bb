require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"
PR = "r1"

DEPENDS += "util-linux-ng"

FILES_${PN} += "${libdir}X11/xinit"
