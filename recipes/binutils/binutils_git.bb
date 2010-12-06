FILESPATHPKG =. "binutils-git:"
SRCREV = "8e34e0b00b49977c905554ebd6e793b095ec2f05"
require binutils.inc
PR = "${INC_PR}.3"
PR_append = "+gitr${SRCPV}"

S = "${WORKDIR}/git"
SRC_URI = "git://sources.redhat.com/git/binutils.git;branch=binutils-2_21-branch;protocol=git \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://fix-clone-conflicts.patch \
     "
