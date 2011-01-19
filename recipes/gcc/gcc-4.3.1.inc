# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-99"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r26"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://fedora/gcc43-c++-builtin-redecl.patch;striplevel=0 \
	file://fedora/gcc43-ia64-libunwind.patch;striplevel=0 \
	file://fedora/gcc43-java-nomulti.patch;striplevel=0 \
	file://fedora/gcc43-ppc32-retaddr.patch;striplevel=0 \
	file://fedora/gcc43-pr27898.patch;striplevel=0 \
	file://fedora/gcc43-pr32139.patch;striplevel=0 \
	file://fedora/gcc43-pr33763.patch;striplevel=0 \
	file://fedora/gcc43-rh330771.patch;striplevel=0 \
	file://fedora/gcc43-rh341221.patch;striplevel=0 \
	file://fedora/gcc43-cpp-pragma.patch;striplevel=0 \
	file://fedora/gcc43-java-debug-iface-type.patch;striplevel=0 \
	file://fedora/gcc43-libgomp-speedup.patch;striplevel=0 \
	file://fedora/gcc43-i386-libgomp.patch;striplevel=0 \
	file://fedora/gcc43-rh251682.patch;striplevel=0 \
	file://debian/arm-unbreak-eabi-armv4t.dpatch;apply=yes \
        file://debian/armel-atomic-builtins.dpatch;apply=yes;striplevel=0 \
	file://debian/libstdc++-pic.dpatch;apply=yes;striplevel=0 \
	file://debian/gcc-ice-hack.dpatch;apply=yes;striplevel=0 \ 
	file://debian/pr30961.dpatch;apply=yes;striplevel=0 \
	file://100-uclibc-conf.patch \
	file://103-uclibc-conf-noupstream.patch \
	file://200-uclibc-locale.patch \
	file://203-uclibc-locale-no__x.patch \
	file://204-uclibc-locale-wchar_fix.patch \
	file://205-uclibc-locale-update.patch \
	file://301-missing-execinfo_h.patch \
	file://302-c99-snprintf.patch \
	file://303-c99-complex-ugly-hack.patch \
	file://304-index_macro.patch \
	file://305-libmudflap-susv3-legacy.patch \
	file://306-libstdc++-namespace.patch \
	file://307-locale_facets.patch \
#	file://402-libbackend_dep_gcov-iov.h.patch \
	file://602-sdk-libstdc++-includes.patch \
	file://740-sh-pr24836.patch \
	file://800-arm-bigendian.patch \
	file://904-flatten-switch-stmt-00.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
        file://gcc-4.4-20090519-arm-eabi-atomic-builtins-unbreak-v2.patch \
	file://cache-amnesia.patch \
	file://gfortran-4.3.x.patch \
	file://gcc-4.0.2-e300c2c3.patch \
#	file://pr34130.patch \
#	file://fortran-static-linking.patch \
	file://gcc-arm-frename-registers.patch \
	file://gcc-release-branch/PR-36500-fix-neon.patch \
	file://gcc-4.3.1-SYSROOT_CFLAGS_FOR_TARGET.patch \
	file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	file://zecke-xgcc-cpp.patch \
	file://gcc-4.3.x-fix-EXTRA_BUILD.patch \
	file://gcc-flags-for-build.patch \
	file://Makefile.in.patch \
"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

# Language Overrides
FORTRAN = ""
JAVA = ""
FORTRAN_linux-gnueabi = ",fortran"

EXTRA_OECONF_BASE = "  --enable-cheaders=c_std --enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

SRC_URI[archive.md5sum] = "4afa0290cc3a41ac8822666f1110de98"
SRC_URI[archive.sha256sum] = "66596b80995f88cb66aaaf937598df7a9af10cc06799c3a7a64879e20b552fd5"
