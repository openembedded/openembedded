DESCRIPTION = "2.6 Linux Kernel for Boundary Devices NEON Board"
SECTION = "kernel"
HOMEPAGE = "N/A"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "bd-neon"
DEPENDS += "u-boot-utils-native"

PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2;name=kernel \
           http://www.boundarydevices.com/boundary-2.6.22-2007-07-22.patch.bz2;patch=1;name=patch \
           file://neon-jffs2-config.patch;patch=1"

S = "${WORKDIR}/linux-2.6.22"

inherit kernel

KERNEL_IMAGETYPE = "zImage"
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

do_configure() {
        cp arch/arm/configs/neon_defconfig .config || die "No default configuration for ${MACHINE} available."

#        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then
#                echo "CONFIG_AEABI=y"                   >> ${S}/.config
#                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
#        else
#                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
#                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
#        fi

        yes '' | oe_runmake oldconfig
}

do_deploy_append() {
        ${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
        rm -f linux.bin.gz
        gzip -9 linux.bin
        ${STAGING_BINDIR_NATIVE}/mkimage -A arm -O linux -T kernel -C gzip -a a0008000 -e a0008000 -n "Boundary Devices NEON" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin
        rm -f linux.bin.gz
}

SRC_URI[kernel.md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[kernel.sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
SRC_URI[patch.md5sum] = "7dac7a5cf401070ecccf42666a30fc0a"
SRC_URI[patch.sha256sum] = "da8a360035464defd133a4ba604aa7ae9ee077747511b98384862b4cbdde5906"
