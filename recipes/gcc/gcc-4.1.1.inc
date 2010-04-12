require gcc-common.inc

DEPENDS = "mpfr gmp"

INC_PR = "r1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch;patch=1 \
	file://110-arm-eabi.patch;patch=1 \
	file://200-uclibc-locale.patch;patch=1 \
	file://300-libstdc++-pic.patch;patch=1 \
	file://301-missing-execinfo_h.patch;patch=1 \
	file://302-c99-snprintf.patch;patch=1 \
	file://303-c99-complex-ugly-hack.patch;patch=1 \
	file://304-index_macro.patch;patch=1 \
	file://602-sdk-libstdc++-includes.patch;patch=1 \
	file://740-sh-pr24836.patch;patch=1 \
	file://800-arm-bigendian.patch;patch=1 \
	file://801-arm-bigendian-eabi.patch;patch=1 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://gcc41-configure.in.patch;patch=1 \
	file://arm-thumb.patch;patch=1 \
	file://arm-thumb-cache.patch;patch=1 \
	file://cse.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://unbreak-armv4t.patch;patch=1 \
        file://fix-ICE-in-arm_unwind_emit_set.diff;patch=1 \
        file://gcc-4.1.1-pr13685-1.patch;patch=1 \
        file://gcc-ignore-cache.patch;patch=1 \
        file://gcc-4.1.1-e300cx.patch;patch=1 \
        file://pr34130.patch;patch=1 \
	file://sed-fixinc-backslash.patch;patch=1 \
	"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;patch=1 "

#This is a dirty hack to get gcc 4.1.1 to compile for glibc AND uclibc on ppc
#the patch that is need it to get gcc support soft-floats with glibc, makes gcc fail with uclibc
SRC_URI_append_linux = " file://ppc-gcc-41-20060515.patch;patch=1 \
                         file://ppc-sfp-long-double-gcc411-7.patch;patch=1 "

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"

SRC_URI[archive.md5sum] = "ad9f97a4d04982ccf4fd67cb464879f3"
SRC_URI[archive.sha256sum] = "985cbb23a486570a8783395a42a8689218f5218a0ccdd6bec590eef341367bb7"
