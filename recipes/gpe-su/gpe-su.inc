DESCRIPTION = "GPE Graphical root-shell frontend"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget virtual/libintl"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

inherit gpe pkgconfig

SRC_URI += "file://makefile-fix.patch"
