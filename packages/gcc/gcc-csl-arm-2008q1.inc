require gcc-common.inc

BINV = "4.2.3"
PV = "4.2.3+csl-arm-2008q1-126"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2008q1-126-arm-none-eabi.src.tar.bz2 \
           file://gcc41-configure.in.patch;patch=1 \
           file://arm-nolibfloat.patch;patch=1 \
           file://arm-softfloat.patch;patch=1 \
           file://ldflags.patch;patch=1 \
           file://zecke-xgcc-cpp.patch;patch=1 \
           file://gfortran.patch;patch=1 \
           file://fortran-static-linking.patch;patch=1 \
#           file://gcc-configure-no-fortran.patch;patch=1;pnum=1 \
#           file://gcc-new-makeinfo.patch;patch=1 \
"

S = "${WORKDIR}/gcc-4.2"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-2008q1-126-arm-none-eabi/gcc-2008q1-126.tar.bz2
}

# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ",java"

EXTRA_OECONF_BASE = "--disable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
ARM_INSTRUCTION_SET = "arm"

addtask unpack2 after do_unpack before do_patch
