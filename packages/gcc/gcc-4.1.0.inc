require gcc-common.inc
PR = "r3"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnu.org/pub/gnu/gcc/gcc-4.1.0/gcc-4.1.0.tar.bz2 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://ldflags.patch;patch=1 \
    file://pr34130.patch;patch=1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

require gcc4-build.inc
EXTRA_OECONF += "--disable-libssp"

FORTRAN = ""


