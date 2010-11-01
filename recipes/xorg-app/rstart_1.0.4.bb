require xorg-app-common.inc
PE = "1"
PR = "${INC_PR}.0"

FILES_${PN}-dbg += "${libdir}/X11/${PN}/.debug/"
SRC_URI[archive.md5sum] = "eb82a6290dfbaa1fc09a3b7426b2eac2"
SRC_URI[archive.sha256sum] = "133a706735e18946e5260cdd07a8400dbf4f8c557f5384b158b79c342609ecbb"
