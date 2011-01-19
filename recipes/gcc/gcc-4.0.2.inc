require gcc-common.inc

INC_PR = "r2"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://gcc-posix-open-fix.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://GCOV_PREFIX_STRIP-cross-profile_4.1.patch \
	file://zecke-xgcc-cpp.patch "

# uclibc patches below
SRC_URI += "file://100-uclibc-conf.patch   \
                   file://200-uclibc-locale.patch \
                   file://301-missing-execinfo_h.patch \
                   file://302-c99-snprintf.patch  \
                   file://303-c99-complex-ugly-hack.patch \
                   file://800-arm-bigendian.patch \
                   file://zecke-host-cpp-ac-hack.patch \
		   file://gcc-4.0.2-atmel.0.99.2.patch \
		   "

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch "

# Language Overrides
FORTRAN = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp"

SRC_URI[archive.md5sum] = "a659b8388cac9db2b13e056e574ceeb0"
SRC_URI[archive.sha256sum] = "37b3286c2bfb68da9df983f60721f868e29897f7a426306748fee93b25c5fb61"
