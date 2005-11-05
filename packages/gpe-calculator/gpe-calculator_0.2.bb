inherit gpe pkgconfig

DESCRIPTION = "A scientific calculator"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://fix_makefile.patch;patch=1"
