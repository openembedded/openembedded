require xorg-app-common.inc
DESCRIPTION = "tiny window manager"
DEPENDS += " libxext libxt libxmu"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "952d06a0c2ec34687b536c7b619fc671"
SRC_URI[archive.sha256sum] = "e7dccad7879a7570442f0cd9df0b9064e926466b5a52b710fca8cfb167f294e9"

FILES_${PN} += "${datadir}/X11/twm/system.twmrc"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"
