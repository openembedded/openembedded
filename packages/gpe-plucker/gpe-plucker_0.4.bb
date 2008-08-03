inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "Plucker ebook reader"
DEPENDS = "gtk+ libgpewidget gpe-icons"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += " file://plucker-no-host-includes.patch;patch=1"
PARALLEL_MAKE=""
EXTRA_OEMAKE="RANLIB=${RANLIB}"

PR = "r2"

