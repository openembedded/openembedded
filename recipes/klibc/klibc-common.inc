DEPENDS = "virtual/kernel perl-native"
SECTION = "libs"
DESCRIPTION = "klibc is intended to be a minimalistic libc subset for \
use with initramfs.  It is deliberately written for small size, \
minimal entaglement, and portability, not speed."
LICENSE = "BSD-ADV"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/klibc/${KLIBC_FETCHDIR}/klibc-${PV}.tar.bz2"

S = "${WORKDIR}/klibc-${PV}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

KLIBC_ARCH = '${TARGET_ARCH}'
KLIBC_ARCH_armeb = 'arm'
KLIBC_ARCH_mipsel = 'mips'
KLIBC_ARCH_x86 = 'i386'
KLIBC_ARCH_i486 = 'i386'
KLIBC_ARCH_i586 = 'i386'
KLIBC_ARCH_i686 = 'i386'
KLIBC_ARCH_pentium = 'i386'

# the klibc code contains ARM instructions (for ARM), this
# could be fixed, but for the moment:
ARM_INSTRUCTION_SET = "arm"

SRC_URI_append_linux-gnueabi = "file://klibc-config-eabi.patch;patch=1"
SRC_URI_append_linux-uclibceabi = "file://klibc-config-eabi.patch;patch=1"

EXTRA_OEMAKE = "'KLIBCARCH=${KLIBC_ARCH}' \
                'CROSS_COMPILE=${TARGET_PREFIX}' \
                "

do_configure () {
        ln -sf ${STAGING_KERNEL_DIR} linux
}
