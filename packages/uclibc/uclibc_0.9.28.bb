DEFAULT_PREFERENCE = "1"
PR = "r1"

include uclibc.inc

# This is the correct KERNEL_SOURCE location, if the uClibc
# fix_includes.sh script is run (see nokernelheader.patch below)
# this must be correct.
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2"

S = "${WORKDIR}/uClibc-${PV}"

#*** PATCHES ***
#
# The nokernelheadercheck patch removes the check on the include
# files in ${KERNEL_SOURCE}, however this check seems to be
# functioning correct now so the patch is not included.  It may
# be necessary to add this for architectures which do not initially
# have a 'good' set of kernel header files in the cross directory.
#SRC_URI += "file://nokernelheadercheck.patch;patch=1"
#
# Thumb support
SRC_URI += " file://thumb-defined-arm-or-thumb.patch;patch=1"
#
# Thumb interworking support
SRC_URI += " file://thumb-mov-pc-bx.patch;patch=1"
SRC_URI += " file://thumb-resolve.patch;patch=1"
