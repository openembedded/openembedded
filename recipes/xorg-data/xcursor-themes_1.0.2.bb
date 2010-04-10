require xorg-data-common.inc
PE = "1"

DEPENDS += " libxcursor xcursorgen-native"

FILES_${PN} += "${datadir}/icons"


SRC_URI[archive.md5sum] = "e8929a1bb4d98d1a3991fd340d0b5f09"
SRC_URI[archive.sha256sum] = "5f798c2f1d2794c09fa0a40700c40359b725107608012866828015dca47514d6"
