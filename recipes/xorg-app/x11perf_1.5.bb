require xorg-app-common.inc

DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PE = "1"

FILES_${PN} += "/usr/lib/X11/x11perfcomp/*"
