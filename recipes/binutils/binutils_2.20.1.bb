require binutils.inc
LICENSE = "GPLv3"

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2;name=tarball \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     file://binutils-x86_64_i386_biarch.patch;patch=1 \
     "

SRC_URI[tarball.sha256sum] = "228b84722d87e88e7fdd36869e590e649ab523a0800a7d53df906498afe6f6f8"
SRC_URI[tarball.md5sum] = "9cdfb9d6ec0578c166d3beae5e15c4e5"

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch;patch=1 \
     "
