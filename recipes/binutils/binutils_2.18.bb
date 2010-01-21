INC_PR = "r8"
PR = "${INC_PR}.2"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://binutils-configure-texinfo-version.patch;patch=1 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     file://binutils-x86_64_i386_biarch.patch;patch=1 \
     file://binutils-section-in-segment.patch;patch=1;pnum=0 \
     file://parse-neon-vmov.diff;patch=1 \
     "

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch;patch=1 \
     file://binutils-powerpc-ld-segfault.patch;patch=1 \
     "

# ep93xx crunch patches
SRC_URI_append_ep9312 = " file://binutils-crunch.patch;patch=1"
