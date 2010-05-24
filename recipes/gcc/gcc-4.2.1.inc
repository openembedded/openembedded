require gcc-common.inc

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

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
	file://pr34130.patch;apply=yes \
"

SRC_URI_avr32 = " http://ewi546.ewi.utwente.nl/tmp/avr32-gcc-4.2.1-atmel.1.0.3.tar.gz;name=atmel \
        file://gcc-pr32889.patch;apply=yes \
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
        file://904-flatten-switch-stmt-00.patch;apply=yes \
        file://gcc41-configure.in.patch;apply=yes \
        file://zecke-xgcc-cpp.patch;apply=yes \
        file://cache-amnesia.patch;apply=yes \
        file://gfortran.patch;apply=yes \
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

EXTRA_OECONF_BASE = "--disable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

ARM_INSTRUCTION_SET = "arm"

SRC_URI[archive.md5sum] = "cba410e6ff70f7d7f4be7a0267707fd0"
SRC_URI[archive.sha256sum] = "ca0a12695b3bccfa8628509e08cb9ed7d8ed48deff0a299e4cb8de87d2c1fced"
SRC_URI[atmel.md5sum] = "566d2a4f588b28bf5cec9638be2ef9fa"
SRC_URI[atmel.sha256sum] = "a83af699303174164e76ba9327ad1b5d210df8c242ba86e4c94f4f35843e7c55"
