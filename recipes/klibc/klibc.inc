DEPENDS = "virtual/kernel perl-native"
SECTION = "libs"
DESCRIPTION = "klibc is intended to be a minimalistic libc subset for \
use with initramfs.  It is deliberately written for small size, \
minimal entaglement, and portability, not speed."
LICENSE = "BSD-ADV"

# We need to point to the kernel headers for ARCH but we do not want to become
# machine specific so we use the headers staged for the current machine.
# (was PACKAGE_ARCH = "${MACHINE_ARCH}")
MACH_STAGING_KERNEL_DIR = "${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"

INC_PR = "r0"

KLIBC_ARCH = '${TARGET_ARCH}'
KLIBC_ARCH_armeb = 'arm'
KLIBC_ARCH_mipsel = 'mips'
KLIBC_ARCH_x86 = 'i386'
KLIBC_ARCH_i486 = 'i386'
KLIBC_ARCH_i586 = 'i386'
KLIBC_ARCH_i686 = 'i386'
KLIBC_ARCH_pentium = 'i386'

KLIBC_FETCHDIR = "1.5"
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/klibc/${KLIBC_FETCHDIR}/klibc-${PV}.tar.bz2"

SRC_URI_append_linux-gnueabi = " file://klibc-config-eabi.patch"
SRC_URI_append_linux-uclibceabi = " file://klibc-config-eabi.patch"

SRC_URI += "\
# extensions
            file://fstype-sane-vfat-and-jffs2-for-1.5.patch \
            file://modprobe.patch \
            file://dash_readopt.patch \
            file://wc.patch \
# cross-compilation patches
            file://staging.patch \
            file://isystem.patch \
# kexec patch for kexec-tools-klibc
            file://klibc_kexecsyscall.patch \
# compatibility patches for >= 2.6.33 kernels
            file://socket.h.patch \
# compatibility patches for <= 2.6.32 kernels
            file://arm-signal-cleanup.patch \
            file://getrusage.patch \
            "

S = "${WORKDIR}/klibc-${PV}"


EXTRA_OEMAKE = "'KLIBCARCH=${KLIBC_ARCH}' \
                'CROSS_COMPILE=${TARGET_PREFIX}' \
                'KLIBCKERNELSRC=${MACH_STAGING_KERNEL_DIR}' \
                "

do_configure () {
        ln -sf ${MACH_STAGING_KERNEL_DIR} linux
}
