DEPENDS = "virtual/kernel perl-native"
SECTION = "libs"
DESCRIPTION = "klibc is intended to be a minimalistic libc subset for \
use with initramfs.  It is deliberately written for small size, \
minimal entaglement, and portability, not speed."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "BSD-ADV"
SRC_URI = "http://www.kernel.org/pub/linux/libs/klibc/Stable/klibc-${PV}.tar.bz2"
SRC_URI += "file://install.patch;patch=1"
S = "${WORKDIR}/klibc-${PV}"

# for the correct kernel staging path
# inherit module-base

EXTRA_OEMAKE = "'ARCH=${KLIBC_ARCH}' \
		'CROSS=${TARGET_PREFIX}' \
		'CC=${HOST_PREFIX}gcc' \
		'LD=${HOST_PREFIX}ld' \
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
		'ARCHREQFLAGS=${HOST_CC_ARCH}' \
		'OPTFLAGS=${TARGET_CFLAGS}' \
		'mandir=${mandir}'"

KLIBC_ARCH = '${TARGET_ARCH}'
KLIBC_ARCH_armeb = 'arm'
KLIBC_ARCH_mipsel = 'mips'

# the klibc code contains ARM instructions (for ARM), this
# could be fixed, but for the moment:
ARM_INSTRUCTION_SET = "arm"

TARGET_CFLAGS := "${@oe_filter_out('-I\S+', '${TARGET_CFLAGS}', d)} -I${STAGING_KERNEL_DIR}/include"

INSTALLDIR = "/usr/lib/klibc"
INSTALLPREFIX = "${INSTALLDIR}/${TARGET_PREFIX}"
INSTALLBINDIR = "${INSTALLPREFIX}bin"
INSTALLLIBDIR = "${INSTALLPREFIX}lib"
INSTALLINCDIR = "${INSTALLPREFIX}include"

PACKAGES = "${PN} ${PN}-dev ${PN}-doc"

FILES_${PN} = "/lib/*.so* ${INSTALLBINDIR}"
FILES_${PN}-dev = "/usr/bin ${INSTALLINCDIR} ${INSTALLLIBDIR}"

do_configure () {
	ln -sf ${STAGING_KERNEL_DIR} linux
}

STAGING_KLIBC_DIR = "${STAGING_DIR}/${HOST_SYS}/klibc"

do_stage() {
	rm -rf "${STAGING_KLIBC_DIR}"
	oe_runmake	'prefix=${STAGING_KLIBC_DIR}' \
			'bindir=${STAGING_BINDIR}' \
			'mandir=${STAGING_DIR}/${BUILD_SYS}/share/man' \
			install
	# The following is sufficient, at least in klibc 1.1.1 to make klcc
	# use the staged libraries and include files.
	sed -i -e 's@^\$prefix = .*$@\$prefix = "${STAGING_KLIBC_DIR}/lib/klibc";@' \
		'${STAGING_BINDIR}/${TARGET_PREFIX}klcc'
}

do_install() {
	# The installed -dev won't work because it has the cross compiler
	# path compiled in.
	oe_runmake 'INSTALLROOT=${D}' install
}
