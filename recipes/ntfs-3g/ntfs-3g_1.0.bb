DESCRIPTION = "The NTFS-3G driver is an open source, freely available NTFS driver for Linux with read and write support."
HOMEPAGE = "http://www.ntfs-3g.org/"
LICENSE = "GPLv2"
DEPENDS = "fuse"
RDEPENDS = "fuse"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = http://www.ntfs-3g.org/ntfs-3g-${PV}.tgz

inherit autotools

EXTRA_OEMAKE = "LDCONFIG=echo"

SRC_URI[md5sum] = "873a8de662849d129fc7c475ad3f5447"
SRC_URI[sha256sum] = "b5bbf81230bb21573d69fc471721b0b0c404eaa5040ef28e7dcec38320a1b2e4"
