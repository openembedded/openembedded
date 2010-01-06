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
