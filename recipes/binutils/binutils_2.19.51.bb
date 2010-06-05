require binutils.inc
PR = "${INC_PR}.0"

LICENSE = "GPLv3"

SRC_URI = "\
     ftp://sourceware.org/pub/binutils/snapshots/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://binutils-arm-pr7093.patch \
     file://ld-stub-crash.patch;striplevel=0 \
     file://thumb-func.patch \
     "

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch"


SRC_URI[md5sum] = "fd59f36022f6ea802d1c844a2576e616"
SRC_URI[sha256sum] = "52f350e2844e87f9e3bb60ade650ad806d020aafa66248ec2a55313d62ed60e4"
