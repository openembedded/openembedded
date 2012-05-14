DESCRIPTION = "GNU dbm is a set of database routines that use extensible hashing."
HOMEPAGE = "http://www.gnu.org/software/gdbm/gdbm.html"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2+"

PR = "r6"

SRC_URI = "${GNU_MIRROR}/gdbm/gdbm-${PV}.tar.gz \
	   file://makefile.patch \
           file://libtool-mode.patch \
           file://chmod.patch"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI[md5sum] = "1d1b1d5c0245b1c00aff92da751e9aa1"
SRC_URI[sha256sum] = "cc340338a2e28b40058ab9eb5354a21d53f88a1582ea21ba0bb185c37a281dc9"

BBCLASSEXTEND = "native"
