SECTION = "kernel"
DESCRIPTION = "Vendor-compatible Linux kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
PR = "r22"

COMPATIBLE_HOST = 'arm.*-linux'
COMPATIBLE_MACHINE = "nslu2"

UNSLUNG_KERNEL_EXTRA_SRC_URI ?= ""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-2.4.22.tar.bz2 \
	   http://nslu.sf.net/downloads/xfs-2.4.22-all-i386.bz2;patch=1 \
	   http://nslu.sf.net/downloads/2.4.22-xfs-nslu2.patch.bz2;patch=1 \
	   file://config-fixes.patch;patch=1 \
	   file://nofpu.patch;patch=1 \
	   file://short_loadbytes.patch;patch=1 \
	   file://gcc3-userfuncs.patch;patch=1 \
	   file://gcc-registerparanoia.patch;patch=1 \
	   file://linux-2.4.24-attribute-used.patch;patch=1 \
	   file://double_cpdo.patch;patch=1 \
	   file://linux-kernel-R25_to_R29.patch;patch=1 \
	   file://linux-kernel-R29_to_R63.patch;patch=1 \
	   file://flash-is-now-hdd.patch;patch=1 \
	   file://gl811e.patch;patch=1 \
	   file://usbnet.patch;patch=1 \
	   file://missing-usb-ioctls.patch;patch=1 \
	   file://anonymiser.patch;patch=1 \
	   file://ppp_mppe.patch;patch=1 \
	   file://nfs-blocksize.patch;patch=1 \
	   file://pl2303.patch;patch=1 \
	   file://pl2303_mdmctl.patch;patch=1 \
	   file://netconsole.patch;patch=1 \
	   file://ppp_mppe_no_fp_in_kernel.patch;patch=1 \
           file://defconfig \
	   ${UNSLUNG_KERNEL_EXTRA_SRC_URI}"
S = "${WORKDIR}/linux-2.4.22"

inherit kernel

ARCH = "arm"
KERNEL_SUFFIX = "nslu2be"
CMDLINE_CONSOLE ?= "ttyS0,115200"
CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 rw init=/linuxrc mem=32M@0x00000000"
CMDLINE = "${CMDLINE_CONSOLE} ${CMDLINE_ROOT}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}
KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}-${DATETIME}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}"
