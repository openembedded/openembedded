require gcc-common.inc

BINV = "3.4.4"
CSV = "2005q3-2"
PV = "3.4.4+csl-arm-${CSV}"
PV_chinook-compat = "3.4.4cs2005q3.2"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-${CSV}-arm-none-eabi.src.tar.bz2 \
           file://gcc_optab_arm.patch;patch=1 \
           file://gcc-3.4.4-eabi-bigendian.patch;patch=1 \
           file://libstdc++_configure.patch;patch=1 \
           file://demangle.patch;patch=1 \
          "

S = "${WORKDIR}/gcc-2005q3"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gcc-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/mpfr-${CSV}.tar.bz2
	tar -xvjf ./arm-${CSV}-arm-none-eabi/gmp-${CSV}.tar.bz2
	mv mpfr-mirror ${S}/mpfr
	mv gmp-mirror ${S}/gmp
}
