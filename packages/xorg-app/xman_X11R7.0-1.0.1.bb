require xorg-app-common.inc

#DESCRIPTION = ""

DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS = " man"

FILES_${PN} += " /usr/share/X11/xman.help"
