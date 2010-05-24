require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r16"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch;apply=yes \
	file://103-uclibc-conf-noupstream.patch;apply=yes \
	file://200-uclibc-locale.patch;apply=yes \
	file://203-uclibc-locale-no__x.patch;apply=yes \
	file://204-uclibc-locale-wchar_fix.patch;apply=yes \
	file://205-uclibc-locale-update.patch;apply=yes \
	file://300-libstdc++-pic.patch;apply=yes \
	file://301-missing-execinfo_h.patch;apply=yes \
	file://302-c99-snprintf.patch;apply=yes \
	file://303-c99-complex-ugly-hack.patch;apply=yes \
	file://304-index_macro.patch;apply=yes \
	file://305-libmudflap-susv3-legacy.patch;apply=yes \
	file://306-libstdc++-namespace.patch;apply=yes \
	file://307-locale_facets.patch;apply=yes \
	file://402-libbackend_dep_gcov-iov.h.patch;apply=yes \
	file://602-sdk-libstdc++-includes.patch;apply=yes \
	file://740-sh-pr24836.patch;apply=yes \
	file://800-arm-bigendian.patch;apply=yes \
	file://801-arm-bigendian-eabi.patch;apply=yes \
	file://904-flatten-switch-stmt-00.patch;apply=yes \
	file://arm-nolibfloat.patch;apply=yes \
	file://arm-softfloat.patch;apply=yes \
	file://gcc41-configure.in.patch;apply=yes \
	file://arm-thumb.patch;apply=yes \
	file://arm-thumb-cache.patch;apply=yes \
	file://zecke-xgcc-cpp.patch;apply=yes \
	file://unbreak-armv4t.patch;apply=yes \
	file://cache-amnesia.patch;apply=yes \
	file://gfortran.patch;apply=yes \
	file://gcc-4.0.2-e300c2c3.patch;apply=yes \
	file://pr34130.patch;apply=yes \
	file://fortran-static-linking.patch;apply=yes \
	file://intermask-bigendian.patch;apply=yes \
"


SRC_URI_append_avr32 = " \
        file://gcc-4.2.2.atmel.1.0.8.patch.bz2;apply=yes \
	file://901-avr32-fix-no-cond-exec-before-reload.patch;apply=yes \
	file://902-avr32-fix-sync-insn-instructions.patch;apply=yes \
	file://903-avr32-fix-removal-of-redundant-cast-operations.patch;apply=yes \
"


SRC_URI_append_ep93xx = " \
        file://arm-crunch-saveregs.patch;apply=yes \
        file://arm-crunch-20000320.patch;apply=yes \
        file://arm-crunch-compare.patch;apply=yes \
        file://arm-crunch-compare-unordered.patch;apply=yes \
        file://arm-crunch-compare-geu.patch;apply=yes \
        file://arm-crunch-eabi-ieee754.patch;apply=yes \
        file://arm-crunch-eabi-ieee754-div.patch;apply=yes \
        file://arm-crunch-64bit-disable0.patch;apply=yes \
        file://arm-crunch-offset.patch;apply=yes \
        file://arm-crunch-fp_consts.patch;apply=yes \
        file://arm-crunch-neg2.patch;apply=yes \
        file://arm-crunch-predicates3.patch;apply=yes \
        file://arm-crunch-cfcvtds-disable.patch;apply=yes \
        file://arm-crunch-floatsi-disable.patch;apply=yes \
        file://arm-crunch-truncsi-disable.patch;apply=yes \
        file://arm-crunch-cfcvt64-disable.patch;apply=yes \
        file://arm-crunch-cirrus-bugfixes.patch;apply=yes \
       "

PACKAGE_ARCH_ep93xx = "${MACHINE_ARCH}"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;apply=yes "

# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

ARM_INSTRUCTION_SET = "arm"

SRC_URI[archive.md5sum] = "7ae33781417a35a2eb03ee098a9f4490"
SRC_URI[archive.sha256sum] = "673b85d780a082c014ded4ac11f8269a3fe893b4dbb584d65b8602d50b3872b1"
