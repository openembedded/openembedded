LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GTK+2 port of the well known game, Tetris."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix-makefiles.patch;patch=1"

SRC_URI[md5sum] = "5c80c48fb82b88955214786843561e78"
SRC_URI[sha256sum] = "592d66d654f8f9ffce6c811ae740e076e4be43c25f16c9945bacaa8eea1060c7"
