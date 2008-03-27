DESCRIPTION = "Linux Kernel for the Iomega storcenter platform"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS = "uboot-utils"
PR = "r0"

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

COMPATIBLE_MACHINE = "storcenter"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://kernel.patch-${PV};patch=1 \
	file://10-command-line.patch;patch=1 \
	file://defconfig-${PV} "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "uImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}"

do_configure() {
		install -m 644 ${WORKDIR}/defconfig-${PV} ${S}/.config
		make ARCH=ppc oldconfig
}

#ppc build leaves the kernel in a different place
#do_movekernel() {
#
#}
