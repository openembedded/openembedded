require xorg-data-common.inc
PE = "1"

DEPENDS += " libxcursor xcursorgen-native"

FILES_${PN} += "${datadir}/icons"

