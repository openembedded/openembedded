require xorg-app-common.inc

DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PE = "1"

FILES_${PN} += "/usr/lib/X11/x11perfcomp/*"

SRC_URI[archive.md5sum] = "31283bfc3c78718ac1bd71e510d4e774"
SRC_URI[archive.sha256sum] = "4729da53dde0b7e1748db4bb771f9b7aaf2e2b1e67293a3a5b96d54043ce1233"
