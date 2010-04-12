require xorg-app-common.inc

DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "fd06c8b8e3572a0e14af65a49e0dd7d1"
SRC_URI[archive.sha256sum] = "c81819618ec596fda55b950ef80f2ee02e5ce149ea99f1f741cedb459b4d3064"
