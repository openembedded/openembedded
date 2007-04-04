DESCRIPTION = "Linux Kernel for x86 compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "i.86.*-linux"
KERNEL_IMAGETYPE = "bzImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/i386/boot/${KERNEL_IMAGETYPE}  ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME} 
}   

do_deploy[dirs] = "${S}"

addtask deploy before do_populate_staging after do_compile
