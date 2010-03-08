# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = ""

INC_PR = "r9"

SRC_URI += "file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
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
SRC_URI[gcctbz2.md5sum] = "927eaac3d44b22f31f9c83df82f26436"
SRC_URI[gcctbz2.sha256sum] = "cbefa9abd4adac0931e1b556072dcd8b32a360d4b95a94d7822c86bded803d5b"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-libssp \
		      --disable-bootstrap --disable-libgomp \
		      --disable-libmudflap"

EXTRA_OECONF_append_linux-uclibc = " ${@base_contains('TARGET_ARCH', 'powerpc', '--disable-decimal-float --without-long-double-128', '',d)}"
