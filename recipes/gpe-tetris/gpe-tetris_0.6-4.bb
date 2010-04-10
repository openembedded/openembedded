LICENSE = "GPL"
inherit gpe
PR = "r1"


DESCRIPTION = "GTK+2 port of the well known game, Tetris."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix-install.patch;patch=1"

SRC_URI[md5sum] = "cd15add33be3857018eef8b57fc262a9"
SRC_URI[sha256sum] = "f43b452ac845b7406fe6b6d7aa9ca64fad731142cd9912e79f03fc5c6b8c10ad"
