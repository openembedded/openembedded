require gcc-common.inc

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://gcc-posix-open-fix.patch;apply=yes \
	file://arm-nolibfloat.patch;apply=yes \
	file://arm-softfloat.patch;apply=yes \
	file://GCOV_PREFIX_STRIP-cross-profile_4.1.patch;apply=yes \
	file://zecke-xgcc-cpp.patch;apply=yes "

# uclibc patches below
SRC_URI_append = " file://100-uclibc-conf.patch;apply=yes   \
                   file://200-uclibc-locale.patch;apply=yes \
                   file://301-missing-execinfo_h.patch;apply=yes \
                   file://302-c99-snprintf.patch;apply=yes  \
                   file://303-c99-complex-ugly-hack.patch;apply=yes \
                   file://800-arm-bigendian.patch;apply=yes \
                   file://zecke-host-cpp-ac-hack.patch;apply=yes \
		   file://gcc-4.0.2-atmel.0.99.2.patch;apply=yes \
		   "

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;apply=yes "

# Language Overrides
FORTRAN = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp"

SRC_URI[archive.md5sum] = "a659b8388cac9db2b13e056e574ceeb0"
SRC_URI[archive.sha256sum] = "37b3286c2bfb68da9df983f60721f868e29897f7a426306748fee93b25c5fb61"
