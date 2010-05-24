INC_PR = "r8"
PR = "${INC_PR}.2"

require binutils.inc
LICENSE = "GPLv3"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;apply=yes \
     file://binutils-configure-texinfo-version.patch;apply=yes \
     file://binutils-uclibc-100-uclibc-conf.patch;apply=yes \
     file://110-arm-eabi-conf.patch;apply=yes \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;apply=yes \
     file://binutils-uclibc-300-006_better_file_error.patch;apply=yes \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;apply=yes \
     file://binutils-uclibc-gas-needs-libm.patch;apply=yes \
     file://binutils-x86_64_i386_biarch.patch;apply=yes \
     file://binutils-section-in-segment.patch;apply=yes;striplevel=0 \
     file://parse-neon-vmov.diff;apply=yes \
     "

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch;apply=yes \
     file://binutils-powerpc-ld-segfault.patch;apply=yes \
     "

# ep93xx crunch patches
SRC_URI_append_ep9312 = " file://binutils-crunch.patch;apply=yes"

SRC_URI[md5sum] = "9d22ee4dafa3a194457caf4706f9cf01"
SRC_URI[sha256sum] = "487a33a452f0edcf1f8bb8fc23dff5c7a82edec3f3f8b65632b6c945e961ee9b"
