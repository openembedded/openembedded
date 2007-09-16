DESCRIPTION = "Linux 2.6.x (development) kernel for FIC SmartPhones shipping w/ OpenMoko"
VANILLA_VERSION = "2.6.22.5"
PV = "${VANILLA_VERSION}-moko11+svnr${SRCREV}"
PR = "r0"

KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

require linux.inc

##############################################################
# source and patches
#
SRCREV_FORMAT = "patches"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2 \
           svn://svn.openmoko.org/trunk/src/target/kernel;module=patches;proto=http;name=patches \
           file://fix-EVIOCGRAB-semantics-2.6.22.5.patch;patch=1 \
           file://defconfig \
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
}

addtask prepatch after do_unpack before do_patch

