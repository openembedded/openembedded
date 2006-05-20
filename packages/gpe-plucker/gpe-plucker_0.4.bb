inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "Plucker ebook reader"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += " file://plucker-no-host-includes.patch;patch=1"
PARALLEL_MAKE=""

PR = "r1"

