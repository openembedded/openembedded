DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r9"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
		   http://www.wantstofly.org/~buytenh/ep93xx/derevo10.diff;patch=1 \
                   file://defconfig \
		   "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


