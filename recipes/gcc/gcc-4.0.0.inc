require gcc-common.inc

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://ldflags.patch;patch=1"
SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

# Language Overrides
FORTRAN = ",f95"

EXTRA_OECONF_BASE = "--disable-libssp"
