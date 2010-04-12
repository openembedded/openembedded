require gcc-common.inc

BINV = "3.4.4"
PV = "3.4.4+csl-arm-2005q3"
PV_chinook-compat = "3.4.4cs2005q3.2"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi.src.tar.bz2;name=archive \
           file://gcc_optab_arm.patch;patch=1 \
           file://gcc-3.4.4-eabi-bigendian.patch;patch=1 \
           file://libstdc++_configure.patch;patch=1 \
           file://demangle.patch;patch=1 \
          "

S = "${WORKDIR}/gcc-2005q3"

do_unpack2() {
	cd ${WORKDIR}
	tar -xvjf ./arm-2005q3-2-arm-none-eabi/gcc-2005q3-2.tar.bz2
}

addtask unpack2 after do_unpack before do_patch

SRC_URI[archive.md5sum] = "3313d991b6cfa993e10b68a6dbda3f0f"
SRC_URI[archive.sha256sum] = "49bb7e3bb94b4ff0b92596c2743db8b7ebef603b26a5b4b4f15bee057ccdb300"
