LICENSE = "GPL"
PR = "r7"

inherit autotools pkgconfig gconf

PROVIDES = "galculator"
DESCRIPTION = "GTK Advanced Calculator"
DEPENDS = "virtual/libc gtk+ libglade gnome-desktop"
RDEPENDS = "gnome-desktop"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
        file://desktop-categories.patch;patch=1 \
        file://Makefile.am.patch;patch=1 \
        file://src-ui.c.patch;patch=1;pnum=0" 

LDFLAGS += '-Wl,--export-dynamic'

