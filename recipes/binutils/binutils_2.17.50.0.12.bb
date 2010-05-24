require binutils.inc
INC_PR = "r5"
PR = "${INC_PR}.1"

SRC_URI = \
    "${KERNELORG_MIRROR}/pub/linux/devel/binutils/binutils-${PV}.tar.bz2 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;apply=yes \
     file://binutils-uclibc-100-uclibc-conf.patch;apply=yes \
     file://110-arm-eabi-conf.patch;apply=yes \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;apply=yes \
     file://binutils-uclibc-300-006_better_file_error.patch;apply=yes \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;apply=yes \
     "

SRC_URI[md5sum] = "6f3e83399b965d70008860f697c50ec2"
SRC_URI[sha256sum] = "7360808266f72aed6fda41735242fb9f1b6dd3307cd6e283a646932438eaa929"
