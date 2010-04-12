require xorg-app-common.inc

DESCRIPTION = "Alter a monitor's gamma correction through the X server"
DEPENDS += " virtual/libx11 libxxf86vm"
PE = "1"

SRC_URI[archive.md5sum] = "f13ddedaa63a608d3b025d326f4f5b5d"
SRC_URI[archive.sha256sum] = "5d3d5b230fc60aefae8f4865c17add133b5fb11377fd61c80897ef94fcccf41e"
