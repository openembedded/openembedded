##############################################################
# kernel image parameters. It resides on a seperate flash partition
#
KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

FILES_kernel-image = ""
ALLOW_EMPTY = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = 'om-gta01|om-gta02'

CMDLINE = "unused -- bootloader passes ATAG list"

###############################################################
# module configs specific to this kernel
#

# usb
module_autoload_ohci-hcd = "ohci-hcd"
module_autoload_hci_usb = "hci_usb"
module_autoload_g_ether = "g_ether"
# audio (GTA01)
module_autoload_snd-soc-neo1973-wm8753 = "snd-soc-neo1973-wm8753"
# audio (GTA02)
module_autoload_snd-soc-neo1973-gta02-wm8753 = "snd-soc-neo1973-gta02-wm8753"
# sd/mmc
module_autoload_s3cmci = "s3cmci"

################################################################
# extra stuff we need for openmoko that is not in linux.inc
#

# fix deconfig if we're on GTA01
do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-oe ${WORKDIR}/defconfig
        if [ ${MACHINE} == "om-gta01" ]; then
                echo -n "fixing up configuration for Openmoko GTA01..."
                sed -i -e s,CONFIG_S3C_LOWLEVEL_UART_PORT=2,CONFIG_S3C_LOWLEVEL_UART_PORT=0, ${WORKDIR}/defconfig
                sed -i -e s,CONFIG_DEBUG_S3C_UART=2,CONFIG_DEBUG_S3C_UART=0, ${WORKDIR}/defconfig
                echo "done"
        fi
}

# symlink the latest uImage (should go to linux.inc IMO)
do_deploy_append() {
	rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.bin
	ln -sf ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE_ARCH}.bin ${DEPLOY_DIR_IMAGE}/uImage-${MACHINE_ARCH}-latest.bin
}

# opkg flash update service
RDEPENDS_kernel-image += "mtd-utils"

pkg_postinst_kernel-image () {
if test "x$D" != "x"; then
        exit 1
else
	if [ -f ${sysconfdir}/default/flashkernel ] ; then
		echo "Upgrading Kernel in Flash"
		echo "DO NOT stop this process"

		MTD_KERNEL_PARTITION=`cat /proc/mtd | grep kernel | cut -d':' -f1`
		MTD_KERNEL_PARTITION=/dev/$MTD_KERNEL_PARTITION

		if [ "x$MTD_KERNEL_PARTITION" = "x" ] ; then
			exit 1
		fi

		${bindir}/flash_eraseall $MTD_KERNEL_PARTITION
		${bindir}/nandwrite -p $MTD_KERNEL_PARTITION /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	else
		touch ${sysconfdir}/default/flashkernel
	fi
fi
}

