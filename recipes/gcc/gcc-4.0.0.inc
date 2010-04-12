require gcc-common.inc

DEPENDS = "mpfr gmp"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://gcc-posix-open-fix.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1"
SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

# Language Overrides
FORTRAN = ",f95"

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"

SRC_URI[archive.md5sum] = "55ee7df1b29f719138ec063c57b89db6"
SRC_URI[archive.sha256sum] = "38a9a01e195000976dcd04ec854c398478ada839510b1de384ffbd5f99791bdc"
