inherit gpe
LICENSE = "PD"

DESCRIPTION = "A simple light puzzle."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe/games"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-makefiles.patch;patch=1"

SRC_URI[md5sum] = "91d4344ab6d00115ee73f7d97c58acee"
SRC_URI[sha256sum] = "98ce715b8627de958cbd4fbc11f72cfb7aed42825eb21995d4d46a676510c126"
