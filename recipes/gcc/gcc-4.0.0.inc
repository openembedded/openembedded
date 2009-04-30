require gcc-common.inc

DEPENDS = "mpfr gmp"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	file://gcc-posix-open-fix.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1"
SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

# Language Overrides
FORTRAN = ",f95"

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
