require gcc-common.inc

BINV = "4.2.1"
PV = "4.2.1+csl-arm-2007q3-53"

FILESPATH = "${FILE_DIRNAME}/gcc-csl-arm-2007q3:${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2007q3-53-arm-none-eabi.src.tar.bz2;name=archive \
           file://gcc-new-makeinfo.patch;apply=yes \
#           file://100-uclibc-conf.patch;apply=yes \
#           file://103-uclibc-conf-noupstream.patch;apply=yes \
#           file://200-uclibc-locale.patch;apply=yes \
#           file://203-uclibc-locale-no__x.patch;apply=yes \
#           file://204-uclibc-locale-wchar_fix.patch;apply=yes \
#           file://205-uclibc-locale-update.patch;apply=yes \
#           file://300-libstdc++-pic.patch;apply=yes \
#           file://302-c99-snprintf.patch;apply=yes \
#           file://303-c99-complex-ugly-hack.patch;apply=yes \
#           file://304-index_macro.patch;apply=yes \
#           file://305-libmudflap-susv3-legacy.patch;apply=yes \
#           file://306-libstdc++-namespace.patch;apply=yes \
#           file://307-locale_facets.patch;apply=yes \
#           file://402-libbackend_dep_gcov-iov.h.patch;apply=yes \
#           file://602-sdk-libstdc++-includes.patch;apply=yes \
           file://gcc41-configure.in.patch;apply=yes \
           file://arm-nolibfloat.patch;apply=yes \
           file://arm-softfloat.patch;apply=yes \
           file://zecke-xgcc-cpp.patch;apply=yes \
#           file://gfortran.patch;apply=yes \
#           file://fortran-static-linking.patch;apply=yes \
#           file://gcc-configure-no-fortran.patch;apply=yes \
#           file://gcc-new-makeinfo.patch;apply=yes \
           file://gcc-Os-fix.diff;apply=yes \
"


S = "${WORKDIR}/gcc-4.2"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-2007q3-53-arm-none-eabi/gcc-2007q3-53.tar.bz2
}

# Language Overrides
FORTRAN = ""
#FORTRAN_linux-gnueabi = ",fortran"
#JAVA = ",java"

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp --disable-bootstrap"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp --disable-bootstrap"


ARM_INSTRUCTION_SET = "arm"

addtask unpack2 after do_unpack before do_patch

SRC_URI[archive.md5sum] = "ada6a8dff4a147f41de02174f8703a0b"
SRC_URI[archive.sha256sum] = "adbc29af4d08e64a221e213597556bf2a7121503fd33a66a2ffceeeffb404e88"
