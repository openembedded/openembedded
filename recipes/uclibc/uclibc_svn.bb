# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-svn takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-snv is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.30"
PV = "${UCLIBC_BASE}+svnr${SRCREV}"
PR = "r1"
#DEFAULT_PREFERENCE = "2"
#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

require uclibc.inc

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-svn', '${FILE_DIRNAME}/uclibc-${UCLIBC_BASE}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI += "svn://uclibc.org/trunk;module=uClibc \
	file://uClibc.machine \
	file://uClibc.distro \
	file://uclibc-arm-ftruncate64.patch;patch=1 \
	file://uclibc_enable_log2_test.patch;patch=1 \
	file://uclibc_ldso_use_O0.patch;patch=1 \
	file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch;patch=1 \
	"
S = "${WORKDIR}/uClibc"
