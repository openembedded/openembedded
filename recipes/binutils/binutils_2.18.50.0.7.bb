
require binutils.inc
PR = "${INC_PR}.1"

LICENSE = "GPLv3"

SRC_URI = "\
     ${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://binutils-arm-pr7093.patch \
     file://binutils-x86_64_i386_biarch.patch \
     "

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch"


SRC_URI[md5sum] = "d5bce238060d631be60a3f1f1009a7ba"
SRC_URI[sha256sum] = "6fe3c4b2d45a50582f832bc77deb4e3da74a15ea8e09dbb214b9c44e7c3378fc"
