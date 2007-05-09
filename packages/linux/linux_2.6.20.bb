DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_n2100 = "\
	   file://n2100-r8169-parity.patch;patch=1 \
	   file://rtc-rs5c372-n2100.patch;patch=1 \
	   "

inherit kernel

KERNEL_IMAGETYPE = "bzImage"
KERNEL_IMAGETYPE_n2100 = "zImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

do_install_append_n2100() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${S}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}
