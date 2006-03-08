DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r11"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.15.tar.bz2 \
  		   http://www.kernel.org/pub/linux/kernel/v2.6/testing/patch-2.6.16-rc5.bz2;patch=1 \   
		   http://www.wantstofly.org/~buytenh/ep93xx/derevo14.diff;patch=1 \
           file://defconfig \
		   "

S = "${WORKDIR}/linux-2.6.15"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make ARCH=arm oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


