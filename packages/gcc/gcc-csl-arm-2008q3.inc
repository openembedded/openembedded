require gcc-common.inc

BINV = "4.3.2"
PV = "4.3.2+csl-arm-2008q3-39"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm-2008q3"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2008q3-39-arm-none-eabi.src.tar.bz2 \
           file://gcc-csl-2008q3-hotfix.diff;patch=1 \
           file://arm-nolibfloat.patch;patch=1 \
           file://arm-softfloat.patch;patch=1 \
           file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch;patch=1 \
           file://gcc-flags-for-build.patch;patch=1 \
           file://gcc-4.3.1-SYSROOT_CFLAGS_FOR_TARGET.patch;patch=1 \
           file://gfortran-csl.patch;patch=1 \
"


S = "${WORKDIR}/gcc-4.3"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-2008q3-39-arm-none-eabi/gcc-2008q3-39.tar.bz2
}

# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
#JAVA = ",java"

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
ARM_INSTRUCTION_SET = "arm"

addtask unpack2 after do_unpack before do_patch
