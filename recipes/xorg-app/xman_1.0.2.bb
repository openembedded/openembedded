require xorg-app-common.inc
PE = "1"

DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS = " man"

FILES_${PN} += " /usr/share/X11/xman.help"

SRC_URI[archive.md5sum] = "855f2dbfa2aff58b8b9cd6a1c1120fad"
SRC_URI[archive.sha256sum] = "00bc616892388c94505b09564daffbad2df2e7c684686dea2d78dbcd210212f2"
