require xorg-app-common.inc
DESCRIPTION = "X11 server performance test program"
DEPENDS += "libxmu libxrender libxft libxext fontconfig"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "c3ac3667a6f5c3cead9847fbf4b5f36e"
SRC_URI[archive.sha256sum] = "394d7355afe7f3b054ce6f30db78794c6305c6593d48b7fb86a9c89d9d9e21bd"

FILES_${PN} += "/usr/lib/X11/x11perfcomp/*"
