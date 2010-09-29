require xorg-app-common.inc
DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "3459958a7fdccf02fa43b70fda9cd87f"
SRC_URI[archive.sha256sum] = "a1fd752abd3496568614c2f2209d21452bdd5b8c9a5c14a5705725bd8c298e12"

FILES_${PN} += "/usr/lib/X11/x11perfcomp/*"
