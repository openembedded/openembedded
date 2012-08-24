require binutils.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.4"
EXTRA_OECONF += "--disable-werror"

#COMPATIBLE_TARGET_SYS = "."

SRC_URI = "\
     ${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2;name=tarball \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://binutils-x86_64_i386_biarch.patch \
     ${@['file://libtool-update.patch','file://libtool-2.4-update.patch'][bb.data.getVar('LIBTOOL_HAS_SYSROOT', d, 1) == 'yes']} \
     file://binutils-2.19.1-ld-sysroot.patch \
     "

SRC_URI_append_nios2 =" \
	file://binutils-nios2-files.patch \
	file://binutils-nios2.patch \
	"

SRC_URI[tarball.sha256sum] = "71d37c96451333c5c0b84b170169fdcb138bbb27397dc06281905d9717c8ed64"
SRC_URI[tarball.md5sum] = "2b9dc8f2b7dbd5ec5992c6e29de0b764"

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch \
     "
