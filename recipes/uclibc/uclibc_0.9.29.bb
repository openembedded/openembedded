# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.29"
PR = "r29"

require uclibc.inc

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "file://uClibc.machine file://uClibc.distro \
		file://errno_values.h.patch;patch=1 \
		file://termios.h.patch;patch=1 \
		file://unistd_arm.patch;patch=1 \
		file://build_wcs_upper_buffer.patch;patch=1 \
		file://uClibc-0.9.29-001-fix-mmap.patch;patch=1 \
		file://uClibc-0.9.29-002-atmel.1.patch;patch=1 \
		file://uClibc-0.9.29-avr32-fix-sa_onstack.patch;patch=1 \
		file://uClibc-0.9.29-conditional-sched_affinity.patch;patch=1 \
		file://uClibc-0.9.29-fix-gethostent_r-failure-retval.patch;patch=1 \
		file://uClibc-0.9.29-fix-internal_function-definition.patch;patch=1 \
		file://uClibc-0.9.29-rm-whitespace.patch;patch=1 \
		file://uClibc-0.9.29-avr32-bzero.patch;patch=1 \
		file://uClibc-0.9.29-nonposix_bashisms.patch;patch=1 \
		file://arm_fix_alignment.patch;patch=1 \
		file://uclibc-arm-ftruncate64.patch;patch=1 \
		file://uclibc-use-fgnu89-inline.patch;patch=1 \
		"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2"

S = "${WORKDIR}/uClibc-${UCLIBC_BASE}"

LEAD_SONAME = "libc.so"
