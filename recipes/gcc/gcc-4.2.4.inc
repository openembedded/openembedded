require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"

INC_PR = "r10"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2 \
	file://100-uclibc-conf.patch;patch=1 \
	file://103-uclibc-conf-noupstream.patch;patch=1 \
	file://200-uclibc-locale.patch;patch=1 \
	file://203-uclibc-locale-no__x.patch;patch=1 \
	file://204-uclibc-locale-wchar_fix.patch;patch=1 \
	file://205-uclibc-locale-update.patch;patch=1 \
	file://300-libstdc++-pic.patch;patch=1 \
	file://301-missing-execinfo_h.patch;patch=1 \
	file://302-c99-snprintf.patch;patch=1 \
	file://303-c99-complex-ugly-hack.patch;patch=1 \
	file://304-index_macro.patch;patch=1 \
	file://305-libmudflap-susv3-legacy.patch;patch=1 \
	file://306-libstdc++-namespace.patch;patch=1 \
	file://307-locale_facets.patch;patch=1 \
	file://402-libbackend_dep_gcov-iov.h.patch;patch=1 \
	file://602-sdk-libstdc++-includes.patch;patch=1 \
	file://740-sh-pr24836.patch;patch=1 \
	file://800-arm-bigendian.patch;patch=1 \
	file://801-arm-bigendian-eabi.patch;patch=1 \
	file://904-flatten-switch-stmt-00.patch;patch=1 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://gcc41-configure.in.patch;patch=1 \
	file://arm-thumb.patch;patch=1 \
	file://arm-thumb-cache.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://unbreak-armv4t.patch;patch=1 \
	file://cache-amnesia.patch;patch=1 \
	file://gfortran.patch;patch=1 \
	file://gcc-4.0.2-e300c2c3.patch;patch=1 \
	file://fortran-static-linking.patch;patch=1 \
	file://intermask-bigendian.patch;patch=1 \
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

PACKAGE_ARCH_ep93xx = "${MACHINE_ARCH}"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;patch=1 "

SRC_URI_append_sh4  = " file://sh_unwind.patch;patch=1 \
			file://cppdefault_cross.patch;patch=1 \
		      "


# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --enable-libgomp --disable-libmudflap"

ARM_INSTRUCTION_SET = "arm"
