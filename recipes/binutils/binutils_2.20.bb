require binutils.inc
LICENSE = "GPLv3"

INC_PR = "r2"
PR = "${INC_PR}.4"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     file://ld-stub-crash.patch;patch=1;pnum=0 \
     file://binutils-arm-non-empty-know.patch;patch=1 \
     file://binutils_unexport_LD_LIBRARY_PATH_for_CC_FOR_BUILD.patch;patch=1 \
     file://binutils-x86_64_i386_biarch.patch;patch=1 \
     "

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch;patch=1 \
     file://binutils-powerpc-pr11088.patch;patch=1 \
     "

SRC_URI[md5sum] = "ee2d3e996e9a2d669808713360fa96f8"
SRC_URI[sha256sum] = "e1df09f0aa3b50154ef93bfefe86d65d01c22cfb44d73299ad95e772133a75b0"
