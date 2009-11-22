DEFAULT_PREFERENCE = "1"

require uclibc.inc
PR = "${INC_PR}.0"

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "http://127.0.0.1/uClibc-${PV}.tar.bz2"
S = "${WORKDIR}/uClibc"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

#SRC_URI += "http://127.0.0.1/uClibc-${PV}.tar.bz2"
#S = "${WORKDIR}/git"
