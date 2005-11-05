inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "Plucker ebook reader"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefiles.patch;patch=1"
