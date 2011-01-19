# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r8"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=gcc444tarbz2 \
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
	file://gcc-add-t-slibgcc-libgcc.patch \
	file://gcc-4.3.3-fix-EXTRA_BUILD.patch \
	file://Makefile.in.patch \
	"
SRC_URI[gcc444tarbz2.md5sum] = "7ff5ce9e5f0b088ab48720bbd7203530"
SRC_URI[gcc444tarbz2.sha256sum] = "e1c13696b45752ad3f652304fab5120a43a8a5c0f438d3bda78cf16b620c0c58"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

EXTRA_OECONF_append_libc-uclibc = " --disable-decimal-float "
