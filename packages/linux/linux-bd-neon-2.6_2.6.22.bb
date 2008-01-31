DESCRIPTION = "2.6 Linux Kernel for Boundary Devices NEON Board"
SECTION = "kernel"
HOMEPAGE = "N/A"
LICENSE = "GPL"
DEPENDS += "u-boot-utils-native"

PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2 \
           http://www.boundarydevices.com/boundary-2.6.22-2007-07-22.patch.bz2;patch=1 \
           file://neon-jffs2-config.patch;patch=1"

S = "${WORKDIR}/linux-2.6.22"

inherit kernel

KERNEL_IMAGETYPE = "zImage"
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

do_configure() {
        cp arch/arm/configs/neon_defconfig .config || die "No default configuration for ${MACHINE} available."

#        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
#                echo "CONFIG_AEABI=y"                   >> ${S}/.config
#                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
#        else
#                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
#                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
#        fi

        yes '' | oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${PR}-${MACHINE}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${PR}-${MACHINE}.tgz -C ${D} lib
        ${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
        rm -f linux.bin.gz
        gzip -9 linux.bin
        ${STAGING_BINDIR_NATIVE}/mkimage -A arm -O linux -T kernel -C gzip -a a0008000 -e a0008000 -n "Boundary Devices NEON" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin
        rm -f linux.bin.gz
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
