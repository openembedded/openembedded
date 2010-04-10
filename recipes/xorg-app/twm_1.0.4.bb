require xorg-app-common.inc
PE = "1"

DESCRIPTION = "tiny window manager"

DEPENDS += " virtual/libx11 libxext libxt libxmu"

ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"

SRC_URI[archive.md5sum] = "0865e14c73c08fa8c501ae877298ee9f"
SRC_URI[archive.sha256sum] = "daa088f9ae231508929b7bd4746e942212b53f2802ca4cee450139fabc8de1fa"
