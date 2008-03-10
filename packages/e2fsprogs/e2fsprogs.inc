DESCRIPTION = "EXT2 Filesystem Utilities"
HOMEPAGE = "http://e2fsprogs.sf.net"
LICENSE = "GPL"
SECTION = "base"

SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-${PV}.tar.gz"

S = "${WORKDIR}/e2fsprogs-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-dynamic-e2fsck --disable-nls --sbindir=${base_sbindir}"

PARALLEL_MAKE = ""
