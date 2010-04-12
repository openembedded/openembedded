inherit gpe pkgconfig
LICENSE = "GPL"
DESCRIPTION = "Plucker ebook reader"
DEPENDS = "gtk+ libgpewidget gpe-icons"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r3"

SRC_URI += " \
           file://plucker-no-host-includes.patch;patch=1 \
           file://fix-install.patch;patch=1 \
           "

PARALLEL_MAKE=""
EXTRA_OEMAKE="RANLIB=${RANLIB}"


SRC_URI[md5sum] = "05e4285049e9458bf1bb52a56f5ffc26"
SRC_URI[sha256sum] = "5a97f5365d97b7332c9aa32e134ec7ae32587873416ec2b6eca2b73635c3f62d"
