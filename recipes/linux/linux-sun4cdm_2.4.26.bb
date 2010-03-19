SECTION = "kernel"
DESCRIPTION = "Linux kernel for sparc32/sun4c"
LICENSE = "GPLv2"
PR = "r0"
DEPENDS += "elftoaout-native"

KERNEL_CCSUFFIX = "-3.3.4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${PV}.tar.bz2 \
           file://defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'sparc.*-linux'

inherit kernel

ARCH = "sparc"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	elftoaout -o ${DEPLOY_DIR_IMAGE}/linux-aout-${DATETIME} ${KERNEL_IMAGETYPE}
}
