LICENSE = "GPL"
PR = "r7"

inherit autotools pkgconfig gconf

PROVIDES = "galculator"
DESCRIPTION = "GTK Advanced Calculator"
DEPENDS = "virtual/libc gtk+ libglade gnome-desktop"
RDEPENDS = "gnome-desktop"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
        file://desktop-categories.patch;patch=1 \
        file://Makefile.am.patch;patch=1 \
        file://src-ui.c.patch;patch=1;pnum=0"

LDFLAGS += '-Wl,--export-dynamic'


SRC_URI[md5sum] = "f42148bcaac4b6b097cf2055c780bcfc"
SRC_URI[sha256sum] = "0ded02d0e6e648024f593f3c3748a73f8f569f680256c393c571144dd77b6fd6"
