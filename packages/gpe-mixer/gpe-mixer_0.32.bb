LICENSE = "GPL"
inherit gpe pkgconfig

DESCRIPTION = "GPE audio mixer"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefile.patch;patch=1"
