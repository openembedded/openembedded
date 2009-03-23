require xorg-app-common.inc

DESCRIPTION = "manual page browser for X"
DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS = " man"
PE = "1"

FILES_${PN} += " /usr/share/X11/xman.help"
