inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "31337 IRC client."
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefile.patch;patch=1"
