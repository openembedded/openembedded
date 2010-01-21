require xorg-app-common.inc
PE = "1"

DEPENDS += " libxaw libxxf86vm libxt"

FILES_${PN} += " ${datadir}/X11/app-defaults/Xvidtune "
