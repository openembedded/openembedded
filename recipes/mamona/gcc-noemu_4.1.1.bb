PR = "r14"
DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"

RCONFLICTS = "gcc"
RREPLACES = "gcc"

inherit autotools gettext

require gcc-package-noemu.inc

SRC_URI = "http://ftp.gnu.org/pub/gnu/gcc/gcc-4.1.1/gcc-4.1.1.tar.bz2 \
	file://100-uclibc-conf.patch;apply=yes \
	file://110-arm-eabi.patch;apply=yes \
	file://200-uclibc-locale.patch;apply=yes \
	file://300-libstdc++-pic.patch;apply=yes \
	file://301-missing-execinfo_h.patch;apply=yes \
	file://302-c99-snprintf.patch;apply=yes \
	file://303-c99-complex-ugly-hack.patch;apply=yes \
	file://304-index_macro.patch;apply=yes \
	file://602-sdk-libstdc++-includes.patch;apply=yes \
	file://740-sh-pr24836.patch;apply=yes \
	file://800-arm-bigendian.patch;apply=yes \
	file://801-arm-bigendian-eabi.patch;apply=yes \
	file://arm-nolibfloat.patch;apply=yes \
	file://arm-softfloat.patch;apply=yes \
	file://gcc41-configure.in.patch;apply=yes \
	file://arm-thumb.patch;apply=yes \
	file://arm-thumb-cache.patch;apply=yes \
	file://ldflags.patch;apply=yes \
	file://cse.patch;apply=yes \
	file://zecke-xgcc-cpp.patch;apply=yes \
	file://unbreak-armv4t.patch;apply=yes \
        file://fix-ICE-in-arm_unwind_emit_set.diff;apply=yes \
        file://gcc-4.1.1-pr13685-1.patch;apply=yes \
        file://gcc-ignore-cache.patch;apply=yes \
	"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;apply=yes "

#This is a dirty hack to get gcc 4.1.1 to compile for glibc AND uclibc on ppc
#the patch that is need it to get gcc support soft-floats with glibc, makes gcc fail with uclibc
SRC_URI_append_linux = " file://ppc-gcc-41-20060515.patch;apply=yes \
                         file://ppc-sfp-long-double-gcc411-7.patch;apply=yes "


#Set the fortran bits
# 'fortran' or '', not 'f77' like gcc3 had
FORTRAN = ""
HAS_GFORTRAN = "no"
HAS_G2C = "no"

#Set the java bits
JAVA_arm = ""
JAVA = ""

LANGUAGES = "c,c++${FORTRAN}${JAVA}"
require ../gcc/gcc-${PV}.inc

EXTRA_OECONF += "--disable-libspp --with-slibdir=\"/lib\""

EXTRA_OEMAKE += "LDFLAGS=\"-static\" build_tooldir=\"${STAGING_DIR}/${TARGET_SYS}\""

HOST_SYS = ${BUILD_SYS}

CONFIG_SITE=""

do_configure () {
    export CPP="gcc -E"
    export CC=gcc
    export AS=as
    export LD=ld
    export CXX=g++ 
    export AR=ar
    export OBJCOPY=objcopy 
    export OBJDUMP=objdump 
    export RANLIB=ranlib 
    export NM=nm 
    export STRIP=strip
    export CFLAGS="-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
    export CXXFLAGS="-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os -fpermissive -fvisibility-inlines-hidden"
    oe_runconf
}

SRC_URI[md5sum] = "ad9f97a4d04982ccf4fd67cb464879f3"
SRC_URI[sha256sum] = "985cbb23a486570a8783395a42a8689218f5218a0ccdd6bec590eef341367bb7"
