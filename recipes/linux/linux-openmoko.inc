##############################################################
# kernel image parameters. It resides on a seperate flash partition
#
KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "om-gta01|om-gta02|om-3d7k"

KERNEL_IMAGE_SYMLINK_NAME_om-gta01 = "uImage-GTA01.bin"
KERNEL_IMAGE_SYMLINK_NAME_om-gta02 = "uImage-GTA02.bin"
KERNEL_IMAGE_SYMLINK_NAME_om-3d7k  = "uImage-OM3D7K.bin"

CMDLINE = "unused -- bootloader passes ATAG list"

# Do keep OABI compat for om-gta01 to keep the gllin binary working
ARM_KEEP_OABI_om-gta01 = "1"

# Make sure not to use thumb[-interworking]
ARM_INSTRUCTION_SET = "arm"
THUMB_INTERWORKING = "no"

###############################################################
# module configs specific to this kernel
#

# usb
module_autoload_ohci-hcd = "ohci-hcd"
module_autoload_hci_usb = "hci_usb"
module_autoload_g_ether = "g_ether"
module_autoload_ppp_generic = "ppp_generic"
# snd modules module_autoload_snd-soc-neo1973-*-wm8753 are in machine.conf 
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
        if [ ${MACHINE} == "om-gta02" ]; then
                echo -n "fixing up configuration for Openmoko GTA02..."
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

# Get the lastest root file system value of boot args
boot_arg=`cat /proc/cmdline |tr " " "\n"|grep "root=" |tail -n 1`
has_mtdblock=`echo $boot_arg |grep mtdblock`

if test "x$D" != "x"; then
        exit 1
elif test "empty$has_mtdblock" != "empty"; then
	if [ -f ${sysconfdir}/default/flashkernel ] ; then
		echo "Upgrading Kernel in Flash"
		echo "DO NOT stop this process"

		MTD_KERNEL_PARTITION=`cat /proc/mtd | grep kernel | cut -d':' -f1`
		MTD_KERNEL_PARTITION=/dev/$MTD_KERNEL_PARTITION

		if [ "x$MTD_KERNEL_PARTITION" = "x" ] ; then
			exit 1
		fi

		if [ ! -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ] ; then
			exit 1
		fi

		${bindir}/flash_eraseall $MTD_KERNEL_PARTITION
		${bindir}/nandwrite -p $MTD_KERNEL_PARTITION /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	else
		touch ${sysconfdir}/default/flashkernel
	fi
else
        echo "You are not booting from NAND, don't flash kernel into mtdblock."
fi
}

