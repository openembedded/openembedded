# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r8"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://fedora/gcc43-c++-builtin-redecl.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-ia64-libunwind.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-java-nomulti.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-ppc32-retaddr.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-pr27898.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-pr32139.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-pr33763.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-rh330771.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-rh341221.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-cpp-pragma.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-java-debug-iface-type.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-libgomp-speedup.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-i386-libgomp.patch;apply=yes;striplevel=0 \
	file://fedora/gcc43-rh251682.patch;apply=yes;striplevel=0 \
	file://debian/arm-unbreak-eabi-armv4t.dpatch;apply=yes \
	file://debian/libstdc++-pic.dpatch;apply=yes;striplevel=0 \
	file://debian/gcc-ice-hack.dpatch;apply=yes;striplevel=0 \ 
	file://debian/pr30961.dpatch;apply=yes;striplevel=0 \
	file://100-uclibc-conf.patch;apply=yes \
	file://103-uclibc-conf-noupstream.patch;apply=yes \
	file://200-uclibc-locale.patch;apply=yes \
	file://203-uclibc-locale-no__x.patch;apply=yes \
	file://204-uclibc-locale-wchar_fix.patch;apply=yes \
	file://205-uclibc-locale-update.patch;apply=yes \
	file://301-missing-execinfo_h.patch;apply=yes \
	file://302-c99-snprintf.patch;apply=yes \
	file://303-c99-complex-ugly-hack.patch;apply=yes \
	file://304-index_macro.patch;apply=yes \
	file://305-libmudflap-susv3-legacy.patch;apply=yes \
	file://306-libstdc++-namespace.patch;apply=yes \
	file://307-locale_facets.patch;apply=yes \
	file://602-sdk-libstdc++-includes.patch;apply=yes \
	file://740-sh-pr24836.patch;apply=yes \
	file://800-arm-bigendian.patch;apply=yes \
	file://904-flatten-switch-stmt-00.patch;apply=yes \
	file://arm-nolibfloat.patch;apply=yes \
	file://arm-softfloat.patch;apply=yes \
	file://cache-amnesia.patch;apply=yes \
	file://gfortran-4.3.x.patch;apply=yes \
	file://gcc-4.0.2-e300c2c3.patch;apply=yes \
#	file://pr34130.patch;apply=yes \
#	file://fortran-static-linking.patch;apply=yes \
	file://gcc-arm-frename-registers.patch;apply=yes \
	file://gcc-4.3.4-SYSROOT_CFLAGS_FOR_TARGET.patch;apply=yes \
	file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;apply=yes \
	file://zecke-xgcc-cpp.patch;apply=yes \
	file://gcc-flags-for-build.patch;apply=yes \
"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;apply=yes "

SRC_URI_append_sh4  = " file://sh_unwind.patch;apply=yes \
			file://gcc-4.2.3-linux-multilib-fix.patch;apply=yes \
		      "
SRC_URI_append_ep93xx = " \
	file://ep93xx/arm-crunch-readme.patch;apply=yes \
	file://ep93xx/arm-crunch-saveregs.patch;apply=yes \
	file://ep93xx/arm-crunch-scratch.patch;apply=yes \
	file://ep93xx/arm-crunch-eabi-ieee754-endian-littleword-littlebyte.patch;apply=yes \
	file://ep93xx/arm-crunch-eabi-mvf0-scratch-ieee754.patch;apply=yes \
	file://ep93xx/arm-crunch-20000320.patch;apply=yes \
	file://ep93xx/arm-crunch-disable-cmpdi.patch;apply=yes \
	file://ep93xx/arm-crunch-fix-64bit-const-offsets.patch;apply=yes \
	file://ep93xx/arm-crunch-fp_consts.patch;apply=yes \
	file://ep93xx/arm-crunch-neg-enable.patch;apply=yes \
	file://ep93xx/arm-crunch-neg-protect.patch;apply=yes \
	file://ep93xx/arm-crunch-repair-truncxfsi.patch;apply=yes \
	file://ep93xx/arm-crunch-floatsi-no-scratch.patch;apply=yes \
	file://ep93xx/arm-crunch-movsf-movdf-Uy.patch;apply=yes \
	file://ep93xx/arm-crunch-drop-thumb2.patch;apply=yes \
	file://ep93xx/arm-crunch-arm_dbx_register_number.patch;apply=yes \
	file://ep93xx/arm-crunch-pipeline.patch;apply=yes \
	file://ep93xx/arm-crunch-ccmav-mode.patch;apply=yes \
	file://ep93xx/arm-crunch-cfcpy-with-cfsh64.patch;apply=yes \
	file://ep93xx/arm-crunch-mieee.patch;apply=yes \
	file://ep93xx/arm-size-bugfix.patch;apply=yes \
	file://ep93xx/arm-prologue_use-length.patch;apply=yes \
	file://ep93xx/arm-crunch-cftruncd32-attr.patch;apply=yes \
	file://ep93xx/arm-crunch-fix-cirrus-reorg7.patch;apply=yes \
	file://ep93xx/arm-crunch-cirrus-di-flag.patch;apply=yes \
	file://ep93xx/arm-crunch-disable-floatsi.patch;apply=yes \
"
# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "  --enable-cheaders=c_std --enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --enable-decimal-float=no"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

SRC_URI[archive.md5sum] = "60df63222dbffd53ca11492a2545044f"
SRC_URI[archive.sha256sum] = "e572453bdb74cc4ceebfab9ffb411d9678343dff5bf86e9338d42fdd0818aa65"
