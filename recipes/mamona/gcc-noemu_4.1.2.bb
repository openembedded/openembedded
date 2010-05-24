DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
# NOTE: split PR.  If the main .bb changes something that affects its *build*
# remember to increment the -cross .bb PR too.
PR = "r0"

RCONFLICTS = "gcc"
RREPLACES = "gcc"
RCONFLICTS_g++-noemu = "g++"
RREPLACES_g++-noemu = "g++"
RCONFLICTS_cpp-noemu = "cpp"
RREPLACES_cpp-noemu = "cpp"

inherit autotools gettext

require gcc-package-noemu.inc

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gcc/gcc-4.1.2/gcc-4.1.2.tar.bz2 \
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
	file://arm-nolibfloat.patch;apply=yes \
	file://arm-softfloat.patch;apply=yes \
	file://gcc41-configure.in.patch;apply=yes \
	file://arm-thumb.patch;apply=yes \
	file://arm-thumb-cache.patch;apply=yes \
	file://ldflags.patch;apply=yes \
	file://zecke-xgcc-cpp.patch;apply=yes \
	file://unbreak-armv4t.patch;apply=yes \
        file://fix-ICE-in-arm_unwind_emit_set.diff;apply=yes \
	file://cache-amnesia.patch;apply=yes \
	file://gfortran.patch;apply=yes \
        file://gcc-4.0.2-e300c2c3.patch;apply=yes \
        file://pr34130.patch;apply=yes \
       "

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;apply=yes "

SRC_URI_avr32 = "http://www.angstrom-distribution.org/unstable/sources/gcc-4.1.2-atmel.1.1.0.tar.gz \
#           file://100-uclibc-conf.patch;apply=yes \
#           file://200-uclibc-locale.patch;apply=yes \
#           file://300-libstdc++-pic.patch;apply=yes \
           file://301-missing-execinfo_h.patch;apply=yes \
           file://302-c99-snprintf.patch;apply=yes \
           file://303-c99-complex-ugly-hack.patch;apply=yes \
           file://304-index_macro.patch;apply=yes \
           file://602-sdk-libstdc++-includes.patch;apply=yes \
           file://gcc41-configure.in.patch;apply=yes \
           file://ldflags.patch;apply=yes \
           file://zecke-xgcc-cpp.patch;apply=yes \
           file://cache-amnesia.patch;apply=yes \
           "

do_compile_prepend_avr32() {
       ln -sf ${S}/libstdc++-v3/config/os/uclibc/ ${S}/libstdc++-v3/config/os/uclibc-linux
}

#Set the fortran bits
# ',fortran' or '', not 'f77' like gcc3 had
FORTRAN = ""
HAS_GFORTRAN = "no"
HAS_G2C = "no"

#Set the java bits
JAVA = ""
JAVA_arm = ""


LANGUAGES = "c,c++${FORTRAN}${JAVA}"
require ../gcc/gcc-${PV}.inc


EXTRA_OECONF += " --disable-libssp --with-slibdir=\"/lib\" "

EXTRA_OEMAKE += "LDFLAGS=\"-static\" build_tooldir=\"${STAGING_DIR}/${TARGET_SYS}\""

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

SRC_URI[md5sum] = "a4a3eb15c96030906d8494959eeda23c"
SRC_URI[sha256sum] = "cfc0efbcc6fcde0d416a32dfb246c9df022515a312683fac412578c4fd09a9bc"
