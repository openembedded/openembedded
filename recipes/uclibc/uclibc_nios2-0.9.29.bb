DEFAULT_PREFERENCE = "1"

require uclibc.inc
PR = "${INC_PR}.0"

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

# from GIT
SRC_URI = "git://sopc.et.ntust.edu.tw/git/uClibc.git;protocol=http"
S = "${WORKDIR}/git"
SRCREV = "e355ed8763cb157ac865bc298478f6ef8c984a11"

# or from an archive:
#SRC_URI = "http://127.0.0.1/uClibc-${PV}.tar.bz2"
#S = "${WORKDIR}/uClibc"

SRC_URI += "${@['${UCLIBC_LOCALE_URI}', ''][bb.data.getVar('USE_NLS', d, 1) != 'yes']} \
file://uClibc.config \
"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"


