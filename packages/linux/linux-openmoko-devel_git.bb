require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for the Openmoko Neo Smartphones"
DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.24"
KERNEL_VERSION = "${KERNEL_RELEASE}"

# If you use a rc, you will need to use this:
PV = "${KERNEL_RELEASE}+gitr${SRCREV}"
PR = "r3"

KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy \
  file://defconfig-oe"
S = "${WORKDIR}/git"

##############################################################
# kernel image resides on a seperate flash partition
#
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
# audio
module_autoload_snd-soc-neo1973-wm8753 = "snd-soc-neo1973-wm8753"
# sd/mmc
module_autoload_s3cmci = "s3cmci"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-oe ${WORKDIR}/defconfig
	if [ ${MACHINE} == "om-gta01" ]; then
		echo -n "fixing up configuration for Openmoko GTA01..."
		sed -i -e s,CONFIG_S3C_LOWLEVEL_UART_PORT=2,CONFIG_S3C_LOWLEVEL_UART_PORT=0, ${WORKDIR}/defconfig
		sed -i -e s,CONFIG_DEBUG_S3C_UART=2,CONFIG_DEBUG_S3C_UART=0, ${WORKDIR}/defconfig
		echo "done"
	fi
}
