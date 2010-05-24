require binutils.inc
LICENSE = "GPLv3"

INC_PR = "r2"
PR = "${INC_PR}.4"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch;apply=yes \
     file://110-arm-eabi-conf.patch;apply=yes \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;apply=yes \
     file://binutils-uclibc-300-006_better_file_error.patch;apply=yes \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;apply=yes \
     file://binutils-uclibc-gas-needs-libm.patch;apply=yes \
     file://ld-stub-crash.patch;apply=yes;striplevel=0 \
     file://binutils-arm-non-empty-know.patch;apply=yes \
     file://binutils_unexport_LD_LIBRARY_PATH_for_CC_FOR_BUILD.patch;apply=yes \
     file://binutils-x86_64_i386_biarch.patch;apply=yes \
     "

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch;apply=yes \
     file://binutils-powerpc-pr11088.patch;apply=yes \
     "

SRC_URI[md5sum] = "ee2d3e996e9a2d669808713360fa96f8"
SRC_URI[sha256sum] = "e1df09f0aa3b50154ef93bfefe86d65d01c22cfb44d73299ad95e772133a75b0"
