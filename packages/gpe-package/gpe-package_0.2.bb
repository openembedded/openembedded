LICENSE = "GPL"
PR = "r1"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "libipkg libgpewidget"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://use-filesel.patch;patch=1 \
	    file://nostropts.patch;patch=1"
