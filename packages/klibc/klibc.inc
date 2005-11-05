DEPENDS = "virtual/kernel"
SECTION = "libs"
DESCRIPTION = "klibc is intended to be a minimalistic libc subset for \
use with initramfs.  It is deliberately written for small size, \
minimal entaglement, and portability, not speed."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "BSD-ADV"
SRC_URI = "http://www.kernel.org/pub/linux/libs/klibc/Stable/klibc-${PV}.tar.bz2"
S = "${WORKDIR}/klibc-${PV}"

# for the correct kernel staging path
# inherit module-base

EXTRA_OEMAKE = "'ARCH=${KLIBC_ARCH}' \
		'CROSS=${TARGET_PREFIX}' \
		'CC=${CC}' \
		'LD=${LD}' \
		'AR=${AR}' \
		'RANLIB=${RANLIB}' \
		'NM=${TARGET_PREFIX}nm' \
		'STRIP=echo' \
		'SHLIBDIR=/lib' \
		'HOST_CC=${BUILD_CC}' \
		'HOST_CFLAGS=${BUILD_CFLAGS}' \
		'HOST_LDFLAGS=${BUILD_LDFLAGS}' \
		'HOST_LIBS=' \
		'LDFLAGS=' \
		'WARNFLAGS=${CFLAGS}' \
		'OPTFLAGS='"

KLIBC_ARCH = '${TARGET_ARCH}'
KLIBC_ARCH_armeb = 'arm'
KLIBC_ARCH_mipsel = 'mips'

CFLAGS := "${@oe_filter_out('-I\S+', '${CFLAGS}', d)} -I${STAGING_KERNEL_DIR}/include"
# CFLAGS := "${@oe_filter_out('-I\S+', '${CFLAGS}', d)}"

do_configure () {
	ln -sf ${STAGING_KERNEL_DIR} linux
}
