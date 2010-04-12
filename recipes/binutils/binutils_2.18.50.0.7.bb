INC_PR = "r7"
PR = "${INC_PR}.1"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     ${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     file://binutils-arm-pr7093.patch;patch=1 \
     file://binutils-x86_64_i386_biarch.patch;patch=1 \
     "

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch;patch=1"


SRC_URI[md5sum] = "d5bce238060d631be60a3f1f1009a7ba"
SRC_URI[sha256sum] = "6fe3c4b2d45a50582f832bc77deb4e3da74a15ea8e09dbb214b9c44e7c3378fc"
