require gcc-common.inc

BINV = "4.1.0"
PV = "4.1.0+csl-arm-2006q1-6"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2006q1-6-arm-none-eabi.src.tar.bz2;name=archive \
           file://gcc-configure-no-fortran.patch;patch=1;pnum=1 \
           file://gcc-new-makeinfo.patch;patch=1"

S = "${WORKDIR}/gcc-2006q1"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-2006q1-6-arm-none-eabi/gcc-2006q1-6.tar.bz2
}

addtask unpack2 after do_unpack before do_patch
SRC_URI[archive.md5sum] = "c0d60035d45c7f43d2ddd3c021709220"
SRC_URI[archive.sha256sum] = "693609f59d0c0a6518a3654314aaef841305e029c8f7de4c42fbc0fd7f2dbb35"
