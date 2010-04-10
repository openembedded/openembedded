LICENSE = "GPL"
PR = "r2"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "ipkg libgpewidget"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://use-filesel.patch;patch=1 \
	    file://nostropts.patch;patch=1"

SRC_URI[md5sum] = "764e50856c99140d20842e05ebb95e3e"
SRC_URI[sha256sum] = "f82ddcf48e582eb1743727c1767a5dc81fa533c1a5ca40f3ac99a50a4479aefd"
