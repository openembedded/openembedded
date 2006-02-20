DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
		   http://wantstofly.org/~buytenh/ep93xx/derevo2.diff;patch=1 \
		   "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

do_configure() {
		make ep93xx_defconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


