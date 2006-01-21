# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date 
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.28"
PV = "${UCLIBC_BASE}+svn${SRCDATE}"
PR = "r2"
#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

include uclibc.inc

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-cvs', '${FILE_DIRNAME}/uclibc-${UCLIBC_BASE}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

# This is the correct KERNEL_SOURCE location, if the uClibc
# fix_includes.sh script is run (see nokernelheader.patch below)
# this must be correct.
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI += "svn://uclibc.org/trunk;module=uClibc"

S = "${WORKDIR}/uClibc"

#*** PATCHES ***
#
# The nokernelheadercheck patch removes the check on the include
# files in ${KERNEL_SOURCE}, however this check seems to be
# functioning correct now so the patch is not included.  It may
# be necessary to add this for architectures which do not initially
# have a 'good' set of kernel header files in the cross directory.
#UCLIBC_PATCHES += "file://nokernelheadercheck.patch;patch=1"
#
# Thumb support
UCLIBC_PATCHES += " file://thumb-defined-arm-or-thumb.patch;patch=1"
#
# Thumb interworking support
UCLIBC_PATCHES += " file://thumb-mov-pc-bx.patch;patch=1"
UCLIBC_PATCHES += " file://thumb-swi-r7.patch;patch=1"
UCLIBC_PATCHES += " file://thumb-sysnum-h.patch;patch=1"
UCLIBC_PATCHES += " file://thumb-asm-swi.patch;patch=1"
UCLIBC_PATCHES += " file://thumb-call-via-rx.patch;patch=1"
#
# This is a core change and is controversial, maybe even wrong
# on some architectures
THUMB_INTERWORK_RESOLVE_PATCH = ""
THUMB_INTERWORK_RESOLVE_PATCH_thumb-interwork = " file://thumb-resolve.patch;patch=1"
UCLIBC_PATCHES += " ${THUMB_INTERWORK_RESOLVE_PATCH}"

# Set this for non-head patches (the above list should match the
# requirements of the SVN head).
UCLIBC_SVN_PATCHES ?= "${UCLIBC_PATCHES}"

SRC_URI += "${UCLIBC_SVN_PATCHES}"
