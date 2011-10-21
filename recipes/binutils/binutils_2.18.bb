require binutils.inc
PR = "${INC_PR}.2"
LICENSE = "GPLv3"

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}a.tar.bz2 \
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

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch \
     file://binutils-powerpc-ld-segfault.patch \
     "

# ep93xx crunch patches
SRC_URI_append_ep9312 = " file://binutils-crunch.patch"

SRC_URI[md5sum] = "ccd264a5fa9ed992a21427c69cba91d3"
SRC_URI[sha256sum] = "4515254f55ec3d8c4d91e7633f3850ff28f60652b2d90dc88eef47c74c194bc9"
