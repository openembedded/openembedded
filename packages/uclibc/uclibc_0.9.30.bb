# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.30"
PR = "r0"
DEFAULT_PREFERENCE = "1"

require uclibc.inc

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "file://uClibc.machine file://uClibc.distro \
            file://arm-linuxthreads.patch;patch=1 \
            file://linuxthreads-changes.patch;patch=1 \
	   "
SRC_URI_append_arm = " file://ldso_hash_arm.patch;patch=1 "
SRC_URI_append_armeb = " file://ldso_hash_arm.patch;patch=1 "

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2"

S = "${WORKDIR}/uClibc-${UCLIBC_BASE}"

LEAD_SONAME = "libc.so"
