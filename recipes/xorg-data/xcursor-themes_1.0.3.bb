require xorg-data-common.inc
PE = "1"

DEPENDS += " libxcursor xcursorgen-native"

FILES_${PN} += "${datadir}/icons"


SRC_URI[archive.md5sum] = "ba21aad0b353f1881f5069e423a44587"
SRC_URI[archive.sha256sum] = "9946618cbd57dfb17d77df8be20d2ae5902c1239b4285787d9704e0ca65a44c7"
PR = "${INC_PR}.0"
