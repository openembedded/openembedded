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

SRC_URI[md5sum] = "88d7aefa03c92739cb70298a0b486e2c"
SRC_URI[sha256sum] = "dab39fb4431c1c6852b4197300b729c5d674906e71ebfada6fe9541fd452ec81"
