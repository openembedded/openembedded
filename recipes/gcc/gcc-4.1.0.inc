require gcc-common.inc

INC_PR = "r10"

DEFAULT_PREFERENCE = "-1"

# Use the same patches as gcc-4.1.1 does
FILESPATHPKG .= ":gcc-4.1.1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
    file://pr34130.patch;patch=1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"

# Language Overrides
FORTRAN = ""


