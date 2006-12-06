DESCRIPTION = "Linux Kernel for the EFIKA dev platform"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"

COMPATIBLE_MACHINE = "efika"

SRC_URI = "http://www.efika.de/download/linux-2.6.19-rc6_efika.tgz \
           file://defconfig \
		   "

S = "${WORKDIR}/linux-2.6.19-rc6_efika"

inherit kernel

KERNEL_IMAGETYPE = "zImage.elf"

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make ARCH=ppc oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


