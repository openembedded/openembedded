INC_PR = "r8"
PR = "${INC_PR}.2"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     http://avr32linux.org/twiki/pub/Main/BinutilsPatches/binutils-${PV}.tar.bz2;name=archive \
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
SRC_URI[archive.md5sum] = "71fb723a456fd902ee785328f0d09cd5"
SRC_URI[archive.sha256sum] = "ea614e9fbec6cb9af08a911660a30991918df44e0328046341f7866ffd2f68d8"

