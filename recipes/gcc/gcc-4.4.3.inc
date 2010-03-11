# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"

INC_PR = "r0"

FILESPATHPKG .= ":gcc-$PV"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=gcc443tarbz2 \
        file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	file://100-uclibc-conf.patch;patch=1 \
	file://gcc-uclibc-locale-ctype_touplow_t.patch;patch=1 \
	file://gcc-disable-linux-unwind-with-libc-inhibit.patch;patch=1 \
	file://gcc-link-libgcc-with-libm.patch;patch=1 \
	file://gcc-improve-tls-macro.patch;patch=1 \
	file://cache-amnesia.patch;patch=1 \
	file://gcc-flags-for-build.patch;patch=1 \
	file://gcc-ppc_single_precision_regs.patch;patch=1 \
	file://gcc-ppc_add_d_constraint.patch;patch=1 \
	file://gcc-pr41175.patch;patch=1 \
	file://gcc-armv4-pass-fix-v4bx-to-ld.patch;patch=1 \
	"
SRC_URI[gcc443tarbz2.md5sum] = "fe1ca818fc6d2caeffc9051fe67ff103"
SRC_URI[gcc443tarbz2.sha256sum] = "97ed664694b02b4d58ac2cafe443d02a388f9cb3645e7778843b5086a5fec040"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--without-long-double-128', '',d)}"
