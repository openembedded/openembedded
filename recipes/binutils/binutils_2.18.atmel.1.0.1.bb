INC_PR = "r8"
PR = "${INC_PR}.2"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     http://avr32linux.org/twiki/pub/Main/BinutilsPatches/binutils-${PV}.tar.bz2;name=archive \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch \
     file://binutils-configure-texinfo-version.patch \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://binutils-x86_64_i386_biarch.patch \
     file://binutils-section-in-segment.patch;striplevel=0 \
     file://parse-neon-vmov.diff \
     "
SRC_URI[archive.md5sum] = "71fb723a456fd902ee785328f0d09cd5"
SRC_URI[archive.sha256sum] = "ea614e9fbec6cb9af08a911660a30991918df44e0328046341f7866ffd2f68d8"

