require xorg-app-common.inc
DEPENDS += " libxaw libxxf86vm libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e40eeb4454f2a7cdde3a14f5dfd3aadd"
SRC_URI[archive.sha256sum] = "73ca41bd5e73560663bea0d98149b099cfef5743a2282ca67547e97732618a53"

FILES_${PN} += " ${datadir}/X11/app-defaults/Xvidtune "
