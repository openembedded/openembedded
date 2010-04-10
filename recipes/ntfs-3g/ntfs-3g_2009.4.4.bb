DESCRIPTION = "The NTFS-3G driver is an open source, freely available NTFS driver for Linux with read and write support."
HOMEPAGE = "http://www.ntfs-3g.org/"
LICENSE = "GPLv2"
DEPENDS = "fuse"
RDEPENDS = "fuse"

SRC_URI = http://www.ntfs-3g.org/ntfs-3g-${PV}.tgz

inherit autotools

EXTRA_OEMAKE = "LDCONFIG=echo"

SRC_URI[md5sum] = "e0b5c170f088a8d82968f0a6b34d31da"
SRC_URI[sha256sum] = "bcd39ebe90541f512e605b62911f14f6107239c4ff032d56d5da3dc3c05e0d0f"
