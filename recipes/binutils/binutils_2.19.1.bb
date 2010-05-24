INC_PR = "r1"
PR = "${INC_PR}.1"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;apply=yes \
     file://binutils-uclibc-100-uclibc-conf.patch;apply=yes \
     file://110-arm-eabi-conf.patch;apply=yes \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;apply=yes \
     file://binutils-uclibc-300-006_better_file_error.patch;apply=yes \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;apply=yes \
     file://binutils-uclibc-gas-needs-libm.patch;apply=yes \
     file://binutils-arm-pr7093.patch;apply=yes \
     file://binutils-x86_64_i386_biarch.patch;apply=yes \
     "

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch;apply=yes"


SRC_URI[md5sum] = "09a8c5821a2dfdbb20665bc0bd680791"
SRC_URI[sha256sum] = "3e8225b4d7ace0a2039de752e11fd6922d3b89a7259a292c347391c4788739f6"
