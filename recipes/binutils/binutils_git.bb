FILESPATHPKG =. "binutils-git:"
SRCREV = "4685dd35801488a1da0293061d9f953ffe4e7ae7"
require binutils.inc
PR = "${INC_PR}.3"
PR_append = "+gitr${SRCPV}"
LICENSE = "GPLv3"

S = "${WORKDIR}/git"
SRC_URI = "git://sources.redhat.com/git/binutils.git;branch=master;protocol=git \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://fix-clone-conflicts.patch \
     "
