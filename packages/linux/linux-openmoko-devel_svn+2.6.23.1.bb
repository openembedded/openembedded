require linux.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for FIC SmartPhones shipping w/ OpenMoko"
VANILLA_VERSION = "2.6.23"
#KERNEL_VERSION = "2.6.23-rc9"
KERNEL_RELEASE = "2.6.23.1"

# If you use a rc, you will need to use this:
#PV = "${VANILLA_VERSION}+${KERNEL_RELEASE}-moko11+svnr${SRCREV}"

KERNEL_VERSION = "${KERNEL_RELEASE}"
PV = "${KERNEL_RELEASE}+svnr${SRCREV}"
PR = "r1"

KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

##############################################################
# source and patches
#
SRCREV_FORMAT = "patches"
SRCREV = "3140"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_VERSION}.bz2;patch=1 \
           svn://svn.openmoko.org/branches/src/target/kernel/2.6.23.x;module=patches;proto=http;name=patches \
           file://squashfs-2.6.23.patch;patch=1 \
           file://fix-EVIOCGRAB-semantics-2.6.22.5.patch;patch=1 \
#           file://printascii-2.6.23.patch;patch=1 \
           file://hack-gta02-cpu.patch;patch=1 \
           file://defconfig-2.6.23.1 \
           file://logo_linux_clut224.ppm"
S = "${WORKDIR}/linux-${VANILLA_VERSION}"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = 'fic-gta01|fic-gta02'

CMDLINE = "unused -- bootloader passes ATAG list"

###############################################################
# module configs specific to this kernel
#

# usb
module_autoload_ohci-hcd = "ohci-hcd"
module_autoload_hci_usb = "hci_usb"
module_autoload_g_ether = "g_ether"
# audio
module_autoload_snd-soc-neo1973-wm8753 = "snd-soc-neo1973-wm8753"
# sd/mmc
module_autoload_s3cmci = "s3cmci"

do_prepatch() {
        mv ${WORKDIR}/patches ${S}/patches && cd ${S} && quilt push -av
        mv patches patches.openmoko
        mv .pc .pc.old
	mv ${WORKDIR}/defconfig-${KERNEL_VERSION} ${WORKDIR}/defconfig
}

addtask prepatch after do_unpack before do_patch

###############################################################
# put into deploy directory and append u-boot header
#
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${PR}-${MACHINE}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${PR}-${MACHINE}.tgz -C ${D} lib
        ${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
        rm -f linux.bin.gz
        gzip -9 linux.bin
        ${STAGING_BINDIR_NATIVE}/uboot-mkimage -A arm -O linux -T kernel -C gzip -a 30008000 -e 30008000 -n "OpenMoko Kernel Image Neo1973" \
                                               -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin
        ln -sf ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin ${DEPLOY_DIR_IMAGE}/uImage-${MACHINE}-latest.bin
        rm -f linux.bin.gz
}

