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
