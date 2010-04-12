require xorg-app-common.inc

DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PE = "1"

FILES_${PN} += "/usr/lib/X11/x11perfcomp/*"

SRC_URI[archive.md5sum] = "66e4aa4645f83809071eb69553ed0222"
SRC_URI[archive.sha256sum] = "ab4c6a579f93fa9485ef5be8760a3da0d22acfa743f2114057c5262b77ff7056"
