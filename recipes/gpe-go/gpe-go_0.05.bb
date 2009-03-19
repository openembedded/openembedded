inherit gpe
LICENSE = "GPL"
DESCRIPTION = "A Go Board for GPE."
DEPENDS = "gtk+ libgpewidget gpe-icons"
RDEPENDS = "gdk-pixbuf-loader-jpeg"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-make.patch;patch=1"
