DESCRIPTION = "Linux Kernel for smdk2443 compatible machines"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS += "u-boot-mkimage-openmoko-native"

PR = "r1"

GGSRC = "http://www.xora.org.uk/oe/patches/"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;tag=v2.6.21-rc5 \
           file://0020-Add-ASoC-S3C24xx-platform-support.patch;patch=1 \
           file://0021-Add-Neo1973-ASoC-support.patch;patch=1 \
           file://0022-Add-initial-ASoC-SMDK2440-support.patch;patch=1 \
           file://0023-Add-ASoC-SMDK2440-support-for-WM8956-codec.patch;patch=1 \
           file://0034-Export-ac97_dai.patch;patch=1 \
           file://0036-Move-s3c24xx_i2s_dai-and-add-dma_size.patch;patch=1 \
           file://0037-Use-dma_size-parameter-and-fix-buffdone-oops.patch;patch=1 \
           file://0038-Add-smdk2443-s3c2443-ac97-and-wm9710-support.patch;patch=1 \
           file://asoc-mainline.patch;patch=1 \
           file://defconfig-smdk2443"

S = "${WORKDIR}/git"

inherit kernel

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "smdk2443"

do_configure() {
	install ${WORKDIR}/defconfig-smdk2443 ${S}/.config
	oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        rm -f ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        ln -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
	${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
        rm -f linux.bin.gz
        gzip -9 linux.bin
        uboot-mkimage -A arm -O linux -T kernel -C gzip -a 30008000 -e 30008000 -n "smdk2443 kernel" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${MACHINE}-${DATETIME}.bin
        rm -f linux.bin.gz
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install

KERNEL_RELEASE = "2.6.21-rc5"
