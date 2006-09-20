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
PR = "r3"

#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

require uclibc.inc

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

#recent versions uclibc require real kernel headers 
PACKAGE_ARCH = "${MACHINE_ARCH}"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-cvs', '${FILE_DIRNAME}/uclibc-${UCLIBC_BASE}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_KERNEL_DIR}"

SRC_URI += "svn://uclibc.org/trunk;module=uClibc"

S = "${WORKDIR}/uClibc"

