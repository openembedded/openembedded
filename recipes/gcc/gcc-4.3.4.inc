# No armeb and thumb patches - really needs checking 
DEFAULT_PREFERENCE = "-999"
ARM_INSTRUCTION_SET = "arm"

require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"

INC_PR = "r8"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	file://fedora/gcc43-c++-builtin-redecl.patch;patch=1;pnum=0 \
	file://fedora/gcc43-ia64-libunwind.patch;patch=1;pnum=0 \
	file://fedora/gcc43-java-nomulti.patch;patch=1;pnum=0 \
	file://fedora/gcc43-ppc32-retaddr.patch;patch=1;pnum=0 \
	file://fedora/gcc43-pr27898.patch;patch=1;pnum=0 \
	file://fedora/gcc43-pr32139.patch;patch=1;pnum=0 \
	file://fedora/gcc43-pr33763.patch;patch=1;pnum=0 \
	file://fedora/gcc43-rh330771.patch;patch=1;pnum=0 \
	file://fedora/gcc43-rh341221.patch;patch=1;pnum=0 \
	file://fedora/gcc43-cpp-pragma.patch;patch=1;pnum=0 \
	file://fedora/gcc43-java-debug-iface-type.patch;patch=1;pnum=0 \
	file://fedora/gcc43-libgomp-speedup.patch;patch=1;pnum=0 \
	file://fedora/gcc43-i386-libgomp.patch;patch=1;pnum=0 \
	file://fedora/gcc43-rh251682.patch;patch=1;pnum=0 \
	file://debian/arm-unbreak-eabi-armv4t.dpatch;patch=1 \
	file://debian/libstdc++-pic.dpatch;patch=1;pnum=0 \
	file://debian/gcc-ice-hack.dpatch;patch=1;pnum=0 \ 
	file://debian/pr30961.dpatch;patch=1;pnum=0 \
	file://100-uclibc-conf.patch;patch=1 \
	file://103-uclibc-conf-noupstream.patch;patch=1 \
	file://200-uclibc-locale.patch;patch=1 \
	file://203-uclibc-locale-no__x.patch;patch=1 \
	file://204-uclibc-locale-wchar_fix.patch;patch=1 \
	file://205-uclibc-locale-update.patch;patch=1 \
	file://301-missing-execinfo_h.patch;patch=1 \
	file://302-c99-snprintf.patch;patch=1 \
	file://303-c99-complex-ugly-hack.patch;patch=1 \
	file://304-index_macro.patch;patch=1 \
	file://305-libmudflap-susv3-legacy.patch;patch=1 \
	file://306-libstdc++-namespace.patch;patch=1 \
	file://307-locale_facets.patch;patch=1 \
	file://602-sdk-libstdc++-includes.patch;patch=1 \
	file://740-sh-pr24836.patch;patch=1 \
	file://800-arm-bigendian.patch;patch=1 \
	file://904-flatten-switch-stmt-00.patch;patch=1 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://cache-amnesia.patch;patch=1 \
	file://gfortran-4.3.x.patch;patch=1 \
	file://gcc-4.0.2-e300c2c3.patch;patch=1 \
#	file://pr34130.patch;patch=1 \
#	file://fortran-static-linking.patch;patch=1 \
	file://gcc-arm-frename-registers.patch;patch=1 \
	file://gcc-4.3.4-SYSROOT_CFLAGS_FOR_TARGET.patch;patch=1 \
	file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://gcc-flags-for-build.patch;patch=1 \
"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;patch=1 "

SRC_URI_append_sh4  = " file://sh_unwind.patch;patch=1 \
			file://gcc-4.2.3-linux-multilib-fix.patch;patch=1 \
		      "
SRC_URI_append_ep93xx = " \
	file://ep93xx/arm-crunch-readme.patch;patch=1 \
	file://ep93xx/arm-crunch-saveregs.patch;patch=1 \
	file://ep93xx/arm-crunch-scratch.patch;patch=1 \
	file://ep93xx/arm-crunch-eabi-ieee754-endian-littleword-littlebyte.patch;patch=1 \
	file://ep93xx/arm-crunch-eabi-mvf0-scratch-ieee754.patch;patch=1 \
	file://ep93xx/arm-crunch-20000320.patch;patch=1 \
	file://ep93xx/arm-crunch-disable-cmpdi.patch;patch=1 \
	file://ep93xx/arm-crunch-fix-64bit-const-offsets.patch;patch=1 \
	file://ep93xx/arm-crunch-fp_consts.patch;patch=1 \
	file://ep93xx/arm-crunch-neg-enable.patch;patch=1 \
	file://ep93xx/arm-crunch-neg-protect.patch;patch=1 \
	file://ep93xx/arm-crunch-repair-truncxfsi.patch;patch=1 \
	file://ep93xx/arm-crunch-floatsi-no-scratch.patch;patch=1 \
	file://ep93xx/arm-crunch-movsf-movdf-Uy.patch;patch=1 \
	file://ep93xx/arm-crunch-drop-thumb2.patch;patch=1 \
	file://ep93xx/arm-crunch-arm_dbx_register_number.patch;patch=1 \
	file://ep93xx/arm-crunch-pipeline.patch;patch=1 \
	file://ep93xx/arm-crunch-ccmav-mode.patch;patch=1 \
	file://ep93xx/arm-crunch-cfcpy-with-cfsh64.patch;patch=1 \
	file://ep93xx/arm-crunch-mieee.patch;patch=1 \
	file://ep93xx/arm-size-bugfix.patch;patch=1 \
	file://ep93xx/arm-prologue_use-length.patch;patch=1 \
	file://ep93xx/arm-crunch-cftruncd32-attr.patch;patch=1 \
	file://ep93xx/arm-crunch-fix-cirrus-reorg7.patch;patch=1 \
	file://ep93xx/arm-crunch-cirrus-di-flag.patch;patch=1 \
	file://ep93xx/arm-crunch-disable-floatsi.patch;patch=1 \
"
# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "  --enable-cheaders=c_std --enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"

