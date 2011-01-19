require gcc-common.inc

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r6"

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
	file://801-arm-bigendian-eabi.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://gcc41-configure.in.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
	file://cse.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
        file://fix-ICE-in-arm_unwind_emit_set.diff \
        file://gcc-4.1.1-pr13685-1.patch \
        file://gcc-ignore-cache.patch \
        file://gcc-4.1.1-e300cx.patch \
        file://pr34130.patch \
	file://sed-fixinc-backslash.patch \
	file://Makefile.in.patch \
	"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

#This is a dirty hack to get gcc 4.1.1 to compile for glibc AND uclibc on ppc
#the patch that is need it to get gcc support soft-floats with glibc, makes gcc fail with uclibc
SRC_URI_append_linux = " file://ppc-gcc-41-20060515.patch \
                         file://ppc-sfp-long-double-gcc411-7.patch "

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp --disable-libunwind-exceptions"

SRC_URI[archive.md5sum] = "ad9f97a4d04982ccf4fd67cb464879f3"
SRC_URI[archive.sha256sum] = "985cbb23a486570a8783395a42a8689218f5218a0ccdd6bec590eef341367bb7"
