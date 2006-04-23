inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "Plucker ebook reader"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

PARALLEL_MAKE=""

SRC_URI += "file://fix_makefiles.patch;patch=1 \
            file://remove-render.patch;patch=1 \
	    file://gpe-plucker-desktop.patch;patch=1"

