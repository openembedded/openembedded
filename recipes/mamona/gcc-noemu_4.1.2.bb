DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
# NOTE: split PR.  If the main .bb changes something that affects its *build*
# remember to increment the -cross .bb PR too.
PR = "r1"

RCONFLICTS_${PN} = "gcc"
RREPLACES_${PN} = "gcc"
RCONFLICTS_g++-noemu = "g++"
RREPLACES_g++-noemu = "g++"
RCONFLICTS_cpp-noemu = "cpp"
RREPLACES_cpp-noemu = "cpp"

inherit autotools gettext

require gcc-package-noemu.inc

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gcc/gcc-4.1.2/gcc-4.1.2.tar.bz2 \
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
	file://ldflags.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
        file://fix-ICE-in-arm_unwind_emit_set.diff \
	file://cache-amnesia.patch \
	file://gfortran.patch \
        file://gcc-4.0.2-e300c2c3.patch \
        file://pr34130.patch \
       "

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

SRC_URI_avr32 = "http://www.angstrom-distribution.org/unstable/sources/gcc-4.1.2-atmel.1.1.0.tar.gz \
#           file://100-uclibc-conf.patch \
#           file://200-uclibc-locale.patch \
#           file://300-libstdc++-pic.patch \
           file://301-missing-execinfo_h.patch \
           file://302-c99-snprintf.patch \
           file://303-c99-complex-ugly-hack.patch \
           file://304-index_macro.patch \
           file://602-sdk-libstdc++-includes.patch \
           file://gcc41-configure.in.patch \
           file://ldflags.patch \
           file://zecke-xgcc-cpp.patch \
           file://cache-amnesia.patch \
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
