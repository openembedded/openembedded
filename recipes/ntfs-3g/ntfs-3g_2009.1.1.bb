DESCRIPTION = "The NTFS-3G driver is an open source, freely available NTFS driver for Linux with read and write support."
HOMEPAGE = "http://www.ntfs-3g.org/"
LICENSE = "GPLv2"
DEPENDS = "fuse"
RDEPENDS = "fuse"
PR = "r0"

SRC_URI = http://www.ntfs-3g.org/ntfs-3g-${PV}.tgz

inherit autotools

EXTRA_OEMAKE = "LDCONFIG=echo"
