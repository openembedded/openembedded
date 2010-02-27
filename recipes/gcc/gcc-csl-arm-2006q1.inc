require gcc-common.inc

BINV = "4.1.0"
CSV = "2006q1-6"
PV = "4.1.0+csl-arm-${CSV}"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-${CSV}-arm-none-eabi.src.tar.bz2 \
           file://gcc-configure-no-fortran.patch;patch=1;pnum=1 \
           file://gcc-new-makeinfo.patch;patch=1"

S = "${WORKDIR}/gcc-2006q1"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gcc-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/mpfr-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gmp-${CSV}.tar.bz2
	mv mpfr-mirror ${S}/mpfr
	mv gmp-mirror ${S}/gmp
}
