SECTION = "kernel"
DESCRIPTION = "Linux kernel for sparc32/sun4c"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://sun4c_defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'sparc.*-linux'

inherit kernel

ARCH = "sparc"
KERNEL_IMAGETYPE = "image"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/sun4c_defconfig ${S}/.config
}


SRC_URI[kernel.md5sum] = "f00fd1b5a80f52baf9d1d83acddfa325"
SRC_URI[kernel.sha256sum] = "910f4af05f40ed9a6ab3bc8ccf7ca77365fb7bfe9b5dcfa7ff316e03b354d4ff"
# CHECKSUMS.INI MISMATCH: I got this:
#SRC_URI[md5sum] = "9517ca999e822b898fbdc7e72796b1aa"
#SRC_URI[sha256sum] = "910f4af05f40ed9a6ab3bc8ccf7ca77365fb7bfe9b5dcfa7ff316e03b354d4ff"
