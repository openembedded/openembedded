require xorg-app-common.inc
DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS_${PN} = " man"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "855f2dbfa2aff58b8b9cd6a1c1120fad"
SRC_URI[archive.sha256sum] = "00bc616892388c94505b09564daffbad2df2e7c684686dea2d78dbcd210212f2"

FILES_${PN} += " /usr/share/X11/xman.help"
