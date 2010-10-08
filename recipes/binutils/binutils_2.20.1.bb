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

SRC_URI[tarball.sha256sum] = "228b84722d87e88e7fdd36869e590e649ab523a0800a7d53df906498afe6f6f8"
SRC_URI[tarball.md5sum] = "9cdfb9d6ec0578c166d3beae5e15c4e5"

# powerpc patches
SRC_URI += "\
     file://binutils-2.16.1-e300c2c3.patch \
     "
