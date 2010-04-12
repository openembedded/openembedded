DESCRIPTION = "Gigolo is a frontend to easily manage connections to remote filesystems using GIO/GVfs."
DEPENDS = "pkgconfig gtk+ gvfs"
RDEPENDS = "libxfce4util libxfcegui4 gvfs fuse-utils"

SECTION = "x11"
LICENSE = "GPL-2"
PR = "r3"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://files.uvena.de/${PN}/${PN}-${PV}.tar.bz2"

do_compile() {
   oe_runmake
}

SRC_URI[md5sum] = "e810a525b495d08bce69317aa37d6134"
SRC_URI[sha256sum] = "e4b20c058ba70f3aa0258ff16817e238303f5d1efb87dbac4acf016e628a7151"
