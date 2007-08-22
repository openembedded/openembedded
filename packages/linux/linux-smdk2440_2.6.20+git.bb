DESCRIPTION = "Linux Kernel for smdk2440 compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r1"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRC_URI = "git://opensource.wolfsonmicro.com/linux-2.6-asoc-ggdev;protocol=git;tag=asoc-merge-0002 \
           file://0001-Enable-cs8900A-network-device-for-smdk2440-board.patch;patch=1 \
           file://defconfig-smdk2440"

S = "${WORKDIR}/git"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "smdk2440"

do_configure() {
	install ${WORKDIR}/defconfig-smdk2440 ${S}/.config
	#oe_runmake s3c2410_defconfig
	oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        rm -f ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        ln -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install

KERNEL_RELEASE = "2.6.21"
