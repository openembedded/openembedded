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
	file://ldflags.patch \
	file://cse.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
        file://fix-ICE-in-arm_unwind_emit_set.diff \
        file://gcc-4.1.1-pr13685-1.patch \
        file://gcc-ignore-cache.patch \
	"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

#This is a dirty hack to get gcc 4.1.1 to compile for glibc AND uclibc on ppc
#the patch that is need it to get gcc support soft-floats with glibc, makes gcc fail with uclibc
SRC_URI_append_linux = " file://ppc-gcc-41-20060515.patch \
                         file://ppc-sfp-long-double-gcc411-7.patch "


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
