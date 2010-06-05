require binutils.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.4"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://ld-stub-crash.patch;striplevel=0 \
     file://binutils-arm-non-empty-know.patch \
     file://binutils_unexport_LD_LIBRARY_PATH_for_CC_FOR_BUILD.patch \
     file://binutils-x86_64_i386_biarch.patch \
     "

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch \
     file://binutils-powerpc-pr11088.patch \
     "

SRC_URI[md5sum] = "ee2d3e996e9a2d669808713360fa96f8"
SRC_URI[sha256sum] = "e1df09f0aa3b50154ef93bfefe86d65d01c22cfb44d73299ad95e772133a75b0"
