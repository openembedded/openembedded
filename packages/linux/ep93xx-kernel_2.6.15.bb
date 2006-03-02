DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
		   file://derevo6.diff;patch=1 \
		   "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

do_configure() {
		make ep93xx_defconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


