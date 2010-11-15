FILESPATHPKG =. "binutils-git:"
SRCREV = "6ef128735ce52ee2acf8cfd80f6d72003dd39ab7"
require binutils.inc
PR = "${INC_PR}.2"
PR_append = "+gitr${SRCPV}"

S = "${WORKDIR}/git"
SRC_URI = "git://sources.redhat.com/git/binutils.git;branch=binutils-2_21-branch;protocol=git \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     "
