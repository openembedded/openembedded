DESCRIPTION = "Linux kernel 2.4.20-embedix for Sharp Zaurus SL-C1000 and SL-C3000 devices."
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openzaurus-pxa27x-2.4.20-rmk2-embedix20050602"
SECTION = "kernel"
PV = "2.4.20-rmk2-embedix"
LICENSE = "GPLv2"
KV = "2.4.20"
PR = "r18"

SRC_URI = "http://developer.ezaurus.com/sl_j/source/c3100/20050602/linux-c3100-20050602-rom1_01.tar.bz2 \
           file://P01-C3000-clockup_050221.patch;pnum=2;patch=1 \
           file://P02-C3000-voltage_050221.patch;pnum=2;patch=1 \
           file://P03-C3000-SIGSTOP_FIX_041207.patch;pnum=2;patch=1 \
           file://P04-C3000-UNICON_041206.patch;pnum=2;patch=1 \
           file://P05-C3000-TSPRESSURE_041207.patch;pnum=2;patch=1 \
           file://P06-C3000-WRITETS_041206.patch;pnum=2;patch=1 \
           file://P07-C3000-KBDDEV_041206.patch;pnum=2;patch=1 \
           file://P08-rtc-mremap-mremap2nd-fix_041213.patch;pnum=2;patch=1 \
           file://P09-ext3-isofs-fix_041216.patch;pnum=2;patch=1 \
           file://P10-ntfs-fix_041216.patch;pnum=2;patch=1 \
           file://P11-bluetooth-mh18_041216.patch;pnum=2;patch=1 \
           file://P12-fbcon-fix_041219.patch;pnum=2;patch=1 \
           file://P14-lowlatency_041221.patch;pnum=2;patch=1 \
           file://P17-bvdd_050222.patch;pnum=2;patch=1 \
           file://P18-detailed_battery_050309.patch;pnum=2;patch=1 \
           file://P02++050226.patch;pnum=1;patch=1 \
           \
           file://swap-performance.patch;patch=1 \
           file://iw240_we15-6.diff;patch=1 \
           file://iw241_we16-6.diff;patch=1 \
           file://iw249_we17-13.diff;patch=1 \
           file://iw240_we18-5.diff;patch=1 \
           file://bluecard_cs.patch;patch=1 \
           file://compile.patch;patch=1 \
           file://idecs.patch;patch=1 \
           file://logo.patch;patch=1 \
           file://initsh.patch;patch=1 \
           file://disable-pcmcia-probe.patch;patch=1 \
           file://deviceinfo.patch;patch=1 \
           file://corgi-fbcon-logo.patch;patch=1 \
           file://corgi-default-brightness.patch;patch=1 \
           file://1764-1.patch;patch=1 \
           file://armdeffix.patch;patch=1 \
           file://add-oz-release-string.patch;patch=1 \
           file://saner-spitz-keymap.patch;patch=1 \
           file://defconfig-${MACHINE} "
# Breaks compilation for now, needs to be fixed
# SRC_URI += "file://CPAR050218.patch;patch=1"

S = "${WORKDIR}/linux"

inherit kernel

#
# Create the kernel command line. CMDLINE_CONSOLE is set through kernel.oeclass.
#
CMDLINE_MTDPARTS_spitz   = "mtdparts=sharpsl-nand:7168k@0k(smf),5120k@7168k(root),-(home)  jffs2_orphaned_inodes=delete"
CMDLINE_MTDPARTS_akita   = "mtdparts=sharpsl-nand:7168k@0k(smf),59392k@7168k(root),-(home) jffs2_orphaned_inodes=delete"
CMDLINE_MTDPARTS_borzoi  = "mtdparts=sharpsl-nand:7168k@0k(smf),32768k@7168k(root),-(home) jffs2_orphaned_inodes=delete"
# CMDLINE_INIT = "init=bin/busybox ash"
CMDLINE_INIT = ""
CMDLINE_SHARP_spitz      = "RTC_RESET=1 EQUIPMENT=4 LOGOLANG=1 DEFYEAR=2005 LOGO=1 LAUNCH=q"
CMDLINE_SHARP_akita      = "EQUIPMENT=0 LOGOLANG=1 DEFYEAR=2006 LOGO=1 LAUNCH=q"
CMDLINE_SHARP_borzoi     = "EQUIPMENT=4 LOGOLANG=1 DEFYEAR=2006 LOGO=1 LAUNCH=q"
CMDLINE_ROOT = "root=/dev/mtdblock2"
# Caution: ttyS0 doesn't seem to work for 2.4.20, so it's either NULL or tty1
CMDLINE_CONSOLE = "quiet tty1"
CMDLINE = "${CMDLINE_CONSOLE} ${CMDLINE_ROOT} ${CMDLINE_MTDPARTS} ${CMDLINE_SHARP} ${CMDLINE_INIT}"

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
ALLOW_EMPTY = "1"
FILES_kernel-image = ""
EXTRA_OEMAKE = "OPENZAURUS_RELEASE=-${DISTRO_VERSION}"
KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "(akita|spitz|borzoi)"
COMPATIBLE_MACHINE = "none"

PARALLEL_MAKE = ""

#
# autoload modules
#
module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_pxa27x_bi = "below pxa27x_bi net_fd usbdcore "
module_autoload_pxa27x_bi = "pxa27x_bi"
module_autoload_usb_ohci_pxa27x = "usb_ohci_pxa27x"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
        echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}
