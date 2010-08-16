require xorg-app-common.inc
DESCRIPTION = "manual page browser for X"
DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS_${PN} = " man"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "3d3a4b310a65ccce82472ef83acbbf97"
SRC_URI[archive.sha256sum] = "38e03bfa2d3d109d55342e3539be952268e405fb458fb8c4f87739594a25394a"

FILES_${PN} += " /usr/share/X11/xman.help"
