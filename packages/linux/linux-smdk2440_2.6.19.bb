DESCRIPTION = "Linux Kernel for smdk2440 compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r1"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${GGSRC}smdk2440-cs89x0-r1.patch;patch=1 \
           file://smdk2440-touchscreen-r3.patch;patch=1 \
           http://opensource.wolfsonmicro.com/~lg/asoc/asoc-v0.12.6.patch;patch=1 \
           file://defconfig-smdk2440"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "smdk2440"
KERNEL_IMAGETYPE = "zImage"

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

