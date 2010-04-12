PR = "r2"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     ftp://sourceware.org/pub/binutils/snapshots/binutils-${PV}.tar.bz2 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     file://binutils-arm-pr7093.patch;patch=1 \
     file://ld-stub-crash.patch;patch=1;pnum=0 \
     file://thumb-func.patch;patch=1 \
     "

# powerpc patches
SRC_URI += "file://binutils-2.16.1-e300c2c3.patch;patch=1"


SRC_URI[md5sum] = "fd59f36022f6ea802d1c844a2576e616"
SRC_URI[sha256sum] = "52f350e2844e87f9e3bb60ade650ad806d020aafa66248ec2a55313d62ed60e4"
