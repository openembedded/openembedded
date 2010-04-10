inherit gpe
LICENSE = "GPL"
DESCRIPTION = "A Go Board for GPE."
DEPENDS = "gtk+ libgpewidget gpe-icons"
RDEPENDS = "gdk-pixbuf-loader-jpeg"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-make.patch;patch=1"

SRC_URI[md5sum] = "79a077b7434e7964afe4c116c9da7295"
SRC_URI[sha256sum] = "d6fdfd927c926145c488d099d6984c291218f898902bb9607ddef340201ae142"
