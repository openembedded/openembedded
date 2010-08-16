require xorg-app-common.inc
DESCRIPTION = "tiny window manager"
DEPENDS += " libxext libxt libxmu"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a56b71dc40249195b32b304633c28a3e"
SRC_URI[archive.sha256sum] = "5b41550477a893bf2b82ab73fc7fb6c839ba52d0deac059be1a473dd7bb92a4e"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"
