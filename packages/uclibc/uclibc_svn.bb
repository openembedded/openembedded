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

require uclibc.inc

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

