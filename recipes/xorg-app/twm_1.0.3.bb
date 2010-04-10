require xorg-app-common.inc
PE = "1"

DESCRIPTION = "tiny window manager"

DEPENDS += " virtual/libx11 libxext libxt libxmu"

ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"

SRC_URI[archive.md5sum] = "a56b71dc40249195b32b304633c28a3e"
SRC_URI[archive.sha256sum] = "5b41550477a893bf2b82ab73fc7fb6c839ba52d0deac059be1a473dd7bb92a4e"
