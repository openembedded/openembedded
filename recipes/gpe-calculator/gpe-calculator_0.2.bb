inherit gpe pkgconfig

DESCRIPTION = "A scientific calculator"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://fix_makefile.patch;patch=1"

SRC_URI[md5sum] = "6dc5eed9b200a45cf007f7a7ed4c2d23"
SRC_URI[sha256sum] = "e51bdbba46d7d6950c1f4d3139a167f4c823e403f8a53b30a16cea32c7d540dc"
