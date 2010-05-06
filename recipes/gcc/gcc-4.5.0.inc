DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native"

FILESPATHPKG .= ":gcc-$PV"

INC_PR = "r1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=gcc450tarbz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	   file://100-uclibc-conf.patch;patch=1 \
           file://gcc-uclibc-locale-ctype_touplow_t.patch;patch=1 \
	   file://cache-amnesia.patch;patch=1 \
	   file://gcc-flags-for-build.patch;patch=1 \
	  "

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

SRC_URI[gcc450tarbz2.md5sum] = "ff27b7c4a5d5060c8a8543a44abca31f"
SRC_URI[gcc450tarbz2.sha256sum] = "8293e9efa68a8ec0fdd0dae9c9bd128a8e742566acd9c8fbcfe79d98ed3756c8"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--without-long-double-128', '',d)}"

