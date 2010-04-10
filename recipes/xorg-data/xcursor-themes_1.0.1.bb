require xorg-data-common.inc
PE = "1"

DEPENDS += " libxcursor xcursorgen-native"

FILES_${PN} += "${datadir}/icons"


SRC_URI[archive.md5sum] = "014bad415e64c49994679cdb71a97e37"
SRC_URI[archive.sha256sum] = "4e7dcd402cd045ce1bd1a3de496270e78d6ead2478a0bcb3404072b33c5c9ea0"
