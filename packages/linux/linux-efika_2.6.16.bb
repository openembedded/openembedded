DESCRIPTION = "Linux Kernel for the EFIKA dev platform"
SECTION = "kernel"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
           file://defconfig \
		   "

S = "${WORKDIR}/linux-2.6.16"

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


