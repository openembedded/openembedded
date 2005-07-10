DESCRIPTION = "Linux kernel for Sharp Zaurus SL-C1000 and SL-C3000 devices."
MAINTAINER = "Bernado, Noodles, and Michael 'Mickey' Lauer <mickey@Vanille.de>"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openzaurus-pxa27x-2.4.20-rmk2-embedix20050228"
SECTION = "kernel"
PV = "2.4.20-rmk2-embedix"
LICENSE = "GPL"
KV = "2.4.20"
PR = "r8"

SRC_URI = "http://developer.ezaurus.com/sl_j/source/c1000/20050228/linux-c1000-20050228-rom1_01.tar.bz2 \
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

S = "${WORKDIR}/linux_n1"

inherit kernel

# Breaks compilation for now, needs to be fixed
# SRC_URI += "file://CPAR050218.patch;patch=1"

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
ALLOW_EMPTY = "1"
FILES_kernel-image = ""

#
# mtd layout on spitz (akita has same layout as husky)
#
# dev:    size   erasesize  name
# mtd0: 006b0000 00020000 "Filesystem"
# mtd1: 00700000 00004000 "smf"
# mtd2: 00500000 00004000 "root"
# mtd3: 00400000 00004000 "home"

CMDLINE_MTDPARTS_spitz   = "mtdparts=sharpsl-nand:7168k@0k(smf),5120k@7168k(root),-(home)"
CMDLINE_MTDPARTS_akita   = "mtdparts=sharpsl-nand:7168k@0k(smf),54272k@7168k(root),-(home)"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "OPENZAURUS_RELEASE=-${DISTRO_VERSION}"
KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_pxa27x_bi = "below pxa27x_bi net_fd usbdcore "
module_autoload_pxa27x_bi = "pxa27x_bi"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${PACKAGE_ARCH}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
