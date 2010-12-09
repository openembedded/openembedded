require binutils.inc
PR = "${INC_PR}.0"
LICENSE = "GPLv3"

SRC_URI = "${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://fix-clone-conflicts.patch \
     "
SRC_URI[md5sum] = "c84c5acc9d266f1a7044b51c85a823f5"
SRC_URI[sha256sum] = "60abec5bf448eb930a5a15acb8712612377dc8bcfb13dfd5131228f70561d0c7"
