require gcc-common.inc

INC_PR = "r10"

DEFAULT_PREFERENCE = "-1"

# Use the same patches as gcc-4.1.1 does
FILESPATHPKG .= ":gcc-4.1.1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
    file://pr34130.patch;patch=1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"

# Language Overrides
FORTRAN = ""

SRC_URI[archive.md5sum] = "88785071f29ed0e0b6b61057a1079442"
SRC_URI[archive.sha256sum] = "1159457a0e4c054b709547ae21ff624aebab2033e0d9e5bf46c9cf88b1970606"
