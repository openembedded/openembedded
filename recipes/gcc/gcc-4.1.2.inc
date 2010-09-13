require gcc-common.inc

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

COMPATIBLE_TARGET_SYS = "."

INC_PR = "r25"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch \
	file://110-arm-eabi.patch \
	file://200-uclibc-locale.patch \
	file://300-libstdc++-pic.patch \
	file://301-missing-execinfo_h.patch \
	file://302-c99-snprintf.patch \
	file://303-c99-complex-ugly-hack.patch \
	file://304-index_macro.patch \
	file://602-sdk-libstdc++-includes.patch \
	file://740-sh-pr24836.patch \
	file://800-arm-bigendian.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://gcc41-configure.in.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
        file://fix-ICE-in-arm_unwind_emit_set.diff \
	file://cache-amnesia.patch \
	file://gfortran.patch \
        file://gcc-4.0.2-e300c2c3.patch \
        file://pr34130.patch \
	file://Makefile.in.patch \
       "

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

SRC_URI_append_nios2 = " \
        file://gcc-nios2.patch \
        file://gcc-config-nios2.patch \
        file://nios2-lib-flags.patch \
	"

SRC_URI_avr32 = "http://www.angstrom-distribution.org/unstable/sources/gcc-4.1.2-atmel.1.1.0.tar.gz;name=atmel \
#           file://100-uclibc-conf.patch \
#           file://200-uclibc-locale.patch \
#           file://300-libstdc++-pic.patch \
           file://301-missing-execinfo_h.patch \
           file://302-c99-snprintf.patch \
           file://303-c99-complex-ugly-hack.patch \
           file://304-index_macro.patch \
           file://602-sdk-libstdc++-includes.patch \
           file://gcc41-configure.in.patch \
           file://zecke-xgcc-cpp.patch \
           file://cache-amnesia.patch \
           "

do_compile_prepend_avr32() {
       ln -sf ${S}/libstdc++-v3/config/os/uclibc/ ${S}/libstdc++-v3/config/os/uclibc-linux
}


# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp"


ARM_INSTRUCTION_SET = "arm"

SRC_URI[archive.md5sum] = "a4a3eb15c96030906d8494959eeda23c"
SRC_URI[archive.sha256sum] = "cfc0efbcc6fcde0d416a32dfb246c9df022515a312683fac412578c4fd09a9bc"
SRC_URI[atmel.md5sum] = "4bb4b376f82af84dbd40563112adf471"
SRC_URI[atmel.sha256sum] = "a6a9d6a66eac090a823124733759b8f1360c79acc0bd9e1e725e80e8742bad3d"
