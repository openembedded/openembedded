require gcc-common.inc

BINV = "4.2.3"
CSV = "2008q1-126"
PV = "4.2.3+csl-arm-${CSV}"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-${CSV}-arm-none-eabi.src.tar.bz2 \
#           file://100-uclibc-conf.patch;patch=1 \
#           file://103-uclibc-conf-noupstream.patch;patch=1 \
#           file://200-uclibc-locale.patch;patch=1 \
#           file://203-uclibc-locale-no__x.patch;patch=1 \
#           file://204-uclibc-locale-wchar_fix.patch;patch=1 \
#           file://205-uclibc-locale-update.patch;patch=1 \
#           file://300-libstdc++-pic.patch;patch=1 \
#           file://302-c99-snprintf.patch;patch=1 \
#           file://303-c99-complex-ugly-hack.patch;patch=1 \
#           file://304-index_macro.patch;patch=1 \
#           file://305-libmudflap-susv3-legacy.patch;patch=1 \
#           file://306-libstdc++-namespace.patch;patch=1 \
#           file://307-locale_facets.patch;patch=1 \
#           file://402-libbackend_dep_gcov-iov.h.patch;patch=1 \
#           file://602-sdk-libstdc++-includes.patch;patch=1 \
           file://gcc41-configure.in.patch;patch=1 \
           file://arm-nolibfloat.patch;patch=1 \
           file://arm-softfloat.patch;patch=1 \
           file://zecke-xgcc-cpp.patch;patch=1 \
#           file://gfortran-4.3.x.patch;patch=1 \
#           file://fortran-static-linking.patch;patch=1 \
#           file://gcc-configure-no-fortran.patch;patch=1;pnum=1 \
#           file://gcc-new-makeinfo.patch;patch=1 \
"


S = "${WORKDIR}/gcc-4.2"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gcc-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/mpfr-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gmp-${CSV}.tar.bz2
	mv mpfr-mirror ${S}/mpfr
	mv gmp-mirror ${S}/gmp
}

# Language Overrides
FORTRAN = ""
#FORTRAN_linux-gnueabi = ",fortran"
#JAVA = ",java"

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
ARM_INSTRUCTION_SET = "arm"
