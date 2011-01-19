# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r13"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
        file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	file://100-uclibc-conf.patch \
	file://gcc-uclibc-locale-ctype_touplow_t.patch \
	file://gcc-disable-linux-unwind-with-libc-inhibit.patch \
	file://gcc-link-libgcc-with-libm.patch \
	file://gcc-improve-tls-macro.patch \
	file://cache-amnesia.patch \
	file://gcc-flags-for-build.patch \
	file://gcc-ppc_single_precision_regs.patch \
	file://gcc-ppc_add_d_constraint.patch \
	file://gcc-pr41175.patch \
	file://gcc-armv4-pass-fix-v4bx-to-ld.patch \
	file://gcc-4.3.3-fix-EXTRA_BUILD.patch \
	file://Makefile.in.patch \
	"
# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_libc-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--disable-decimal-float --without-long-double-128', '',d)}"

SRC_URI[archive.md5sum] = "927eaac3d44b22f31f9c83df82f26436"
SRC_URI[archive.sha256sum] = "cbefa9abd4adac0931e1b556072dcd8b32a360d4b95a94d7822c86bded803d5b"
