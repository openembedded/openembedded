require binutils.inc

PR = "r2"

SRC_URI = \
    "${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://binutils-configure-texinfo-version.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     "

SRC_URI[md5sum] = "1441fe6fa44b344d0575cb66d3f89252"
SRC_URI[sha256sum] = "016b0faa1bbe20c13a4b5f495a5a4071349f6385012b767c89bb908452faecf2"
