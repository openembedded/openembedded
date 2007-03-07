DESCRIPTION = "Linux Kernel for the QNAP TurboStation platform"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS = "uboot-utils"
PR = "r5"

# notes on iom def kernel:
#
# can probably remove :
# BLK_DEV_RAM ?
# MD_RAID5
# QUOTA
# QFMT_V2
# DNOTIFY?
# MSDOS_FS, VFAT_FS, NTFS_FS?
#
# USB_GADGET? - USB_GADGET_NET2280, USB_ETH, USB_ETH_RNDIS
#
#
# should add:
#   EXT3_FS
#   PACKET_MMAP ?
#   i2c_chardev?
# usb audio:
#   USB_EMI62?
#   USB_EMI26?

COMPATIBLE_MACHINE = "turbostation"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://001_r1000.diff;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.h;patch=1 \
	file://linux-2.6.16_drivers_i2c_chips_Makefile;patch=1 \
	file://002_qnap-pic.diff;patch=1 \
	file://linux-2.6.16_arch_ppc_syslib_Makefile;patch=1 \
	file://linux-2.6.16_drivers_mtd_maps_physmap.c;patch=1 \
	file://linux-2.6.16_arch_ppc_syslib_mpc10x_common.c;patch=1 \
	file://linux-2.6.16_drivers_net_r8169.c;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_Makefile;patch=1 \
	file://linux-2.6.16_arch_ppc_syslib_open_pic.c;patch=1 \
	file://linux-2.6.16_include_asm-ppc_mpc10x.h;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.c;patch=1 \
	file://linux-2.6.16_drivers_i2c_chips_Kconfig;patch=1 \
	file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "uImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}"
# Override arch. The kernel stuff is in arch/ppc, not arch/powerpc in our case
ARCH = ppc

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make ARCH=ppc oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

#ppc build leaves the kernel in a different place
#do_movekernel() {
#
#}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


