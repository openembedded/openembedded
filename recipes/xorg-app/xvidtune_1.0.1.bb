require xorg-app-common.inc
PE = "1"

DEPENDS += " libxaw libxxf86vm libxt"

FILES_${PN} += " ${datadir}/X11/app-defaults/Xvidtune "

SRC_URI[archive.md5sum] = "e0744594f4e5969b20df28d897781318"
SRC_URI[archive.sha256sum] = "6d0feb42c2f1d6011d97c776b9d580fd589cdf3cfe246cd99437c406a2740d36"
