require gcc-common.inc

BINV = "4.3.2"
CSV = "2008q3-39"
PV = "4.3.2+csl-arm-${CSV}"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm-2008q3"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-${CSV}-arm-none-eabi.src.tar.bz2 \
           file://gcc-csl-2008q3-hotfix.diff;patch=1 \
           file://arm-nolibfloat.patch;patch=1 \
           file://arm-softfloat.patch;patch=1 \
           file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
           file://gcc-flags-for-build.patch;patch=1 \
           file://gcc-4.3.1-SYSROOT_CFLAGS_FOR_TARGET.patch;patch=1 \
           file://gfortran-4.3.x.patch;patch=1 \
"


S = "${WORKDIR}/gcc-4.3"

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
FORTRAN_linux-gnueabi = ",fortran"
#JAVA = ",java"

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
ARM_INSTRUCTION_SET = "arm"
