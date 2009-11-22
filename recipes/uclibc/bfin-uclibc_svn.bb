# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.29"
PV = "${UCLIBC_BASE}+svnr${SRCPV}"

require uclibc.inc
PR = "${INC_PR}.0"
PROVIDES_append_bfin = " virtual/${TARGET_PREFIX}libc-for-gcc "

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_HOST = "bfin.*-uclinux"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI = "svn://sources.blackfin.uclinux.org/toolchain/trunk;module=uClibc "
SRC_URI += "file://uClibc.machine file://uClibc.distro"

FILESPATHPKG =. "uclibc-${UCLIBC_BASE}:uclibc:"


S = "${WORKDIR}/uClibc"

