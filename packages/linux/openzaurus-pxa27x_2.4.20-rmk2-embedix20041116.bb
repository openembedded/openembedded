DESCRIPTION = "Linux kernel for Sharp SL-C3000 processor based devices."
MAINTAINER = "NOT Michael 'Mickey' Lauer <mickey@Vanille.de>"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openzaurus-pxa27x-2.4.20-rmk2-embedix20041116"
SECTION = "kernel"
PV = "2.4.20-rmk2-embedix"
LICENSE = "GPL"
KV = "2.4.20"
PR = "r1"

ALLOW_EMPTY_kernel = "1"

SRC_URI = "http://developer.ezaurus.com/sl_j/source/c3000/20041116/linux-c3000-20041116-rom1_01.tar.bz2 \
           file://swap-performance.patch;patch=1 \
           file://iw240_we15-6.diff;patch=1 \
           file://iw241_we16-6.diff;patch=1 \
           file://bluecard_cs.patch;patch=1 \
           file://enable-sysrq.patch;patch=1 \
           file://compile.patch;patch=1 \
           file://idecs.patch;patch=1 \
           file://logo.patch;patch=1 \
           file://initsh.patch;patch=1 \
           file://keyboard-ctrl+alt.patch;patch=1 \
           file://keymap-more-sane.patch;patch=1 \
           file://disable-pcmcia-probe.patch;patch=1 \
           file://deviceinfo.patch;patch=1 \  
           file://tosa_ts.patch;patch=1 \
           file://corgi-fbcon-logo.patch;patch=1 \
           file://corgi-default-brightness.patch;patch=1 \
           file://1764-1.patch;patch=1 \
           http://us1.samba.org/samba/ftp/cifs-cvs/cifs-1.20c-2.4.tar.gz \
           file://defconfig-${MACHINE} "

S = "${WORKDIR}/linux"

inherit kernel

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
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

EXTRA_OEMAKE = " EMBEDIXRELEASE=-${DISTRO_VERSION}"
KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_pxa_bi = "below pxa27x_bi net_fd usbdcore "
module_autoload_pxa_bi = "pxa27x_bi"

do_configure_prepend() {
	patch -p1 < cifs_24.patch
	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${PACKAGE_ARCH}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
