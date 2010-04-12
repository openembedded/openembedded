require xorg-app-common.inc

DESCRIPTION = "Alter a monitor's gamma correction through the X server"
DEPENDS += " virtual/libx11 libxxf86vm"
PE = "1"

SRC_URI[archive.md5sum] = "e8a88bf1a18f35b724619849dca97f4f"
SRC_URI[archive.sha256sum] = "e5eb2588fbbdc5c2db5571b304204487a9c22eed15ac6cb816f605ec403e6e1a"
