DESCRIPTION = "Linux kernel for MTX-3 (Surfbox3)"
HOMEPAGE = "http://meshcube.org/meshwiki/"
LICENSE = "GPLv2"
KV = "${PV}"
PR = "r11"

inherit kernel
# therefore
# PROVIDES = "virtual/kernel"

DEPENDS = "u-boot"
RDEPENDS = "mtd-utils"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KV}.tar.bz2 \
	file://00-mtx-3.diff;patch=1 \
	file://01-verbose-and-fatal-mkuboot.diff;patch=1 \
	file://defconfig-mtx-3"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-mtx-3-${KV}"

S = "${WORKDIR}/linux-${KV}"


COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "mtx-3"

# overriding default target 'zImage' with U-Boot-Image
# (note: uImage depends on zImage)
# U-Boot's "mkimage" is required for this to work
KERNEL_IMAGETYPE = "uImage"

# overriding default 'boot'
KERNEL_IMAGEDEST = "tmp"

XIP_PHYS_ADDR = "0x00080000"

MTX_KERNEL_NON_PCI_OHCI = "no"

PACKAGE_ARCH = "mtx-3"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-mtx-3 ${S}/.config
	if [ "x${MTX_KERNEL_NON_PCI_OHCI}" == "xyes" ]; then
		echo "CONFIG_USB_NON_PCI_OHCI=y" >> ${S}/.config
	fi
}

do_compile() {

	kernel_do_compile

	# set CONFIG_XIP_KERNEL=y and CONFIG_XIP_PHYS_ADDR=xxxx if commented out, else append it
#        sed -i -e "s/^[#        ]*CONFIG_XIP_KERNEL.*/CONFIG_XIP_KERNEL=y/" \
#                -e "s/^[#       ]*CONFIG_XIP_PHYS_ADDR.*/CONFIG_XIP_PHYS_ADDR=${XIP_PHYS_ADDR}/" .config
#	grep -q "^CONFIG_XIP_PHYS_ADDR=" .config || echo "CONFIG_XIP_PHYS_ADDR=${XIP_PHYS_ADDR}" >>.config

#        oe_runmake xipImage CC="arm-linux-gcc " LD="arm-linux-ld " ARCH="arm"
}

#
# FIXME: we need to find out the proper names and kernel image formats
# used / needed here and then fix the following ...
#

pkg_postinst_kernel() {
if test "x$D" != "x"; then
	exit 1
else
	if test -e /tmp/zImage.flash-${KV}; then
		echo "*** flashing kernel ***"
		flashcp -v /tmp/zImage.flash-${KV} /dev/mtd/2
		echo "*** done. please reboot ***"
	fi
fi
}

FILES_kernel += " /tmp"

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}

# uncompressed Image
	install -m 0644 arch/arm/boot/Image ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}

# xip is probably not very useful for us - text segment reading may be slow on flash and we have enough ram
#	install -m 0644 arch/arm/boot/xipImage ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.xip

# old mtx-2 mips
        #install -m 0644 arch/mips/boot/mtx-3.flash.srec ${DEPLOY_DIR}/images/${KERNEL_IMAGE_NAME}.flash.srec
	#install -m 0644 arch/mips/boot/mtx-3.srec ${DEPLOY_DIR}/images/${KERNEL_IMAGE_NAME}.ram.srec
}
