require gcc-common.inc

INC_PR = "r15"

DEFAULT_PREFERENCE = "-1"

# Use the same patches as gcc-4.1.1 does
FILESPATHPKG .= ":gcc-4.1.1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://zecke-xgcc-cpp.patch \
	file://pr34130.patch \
	file://Makefile.in.patch \
    "

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch "

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp"

# Language Overrides
FORTRAN = ""

SRC_URI[archive.md5sum] = "88785071f29ed0e0b6b61057a1079442"
SRC_URI[archive.sha256sum] = "1159457a0e4c054b709547ae21ff624aebab2033e0d9e5bf46c9cf88b1970606"
