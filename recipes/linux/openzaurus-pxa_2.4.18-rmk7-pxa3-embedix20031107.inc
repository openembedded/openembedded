DESCRIPTION = "Linux kernel for OpenZaurus PXA processor based devices."
SECTION = "kernel"
LICENSE = "GPLv2"
PV = "2.4.18-rmk7-pxa3-embedix"
PR = "r46"
KV = "2.4.18"
RMKV = "7"
PXAV = "3"
SHARPV = "20031107"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openzaurus-pxa-${KV}-rmk${RMKV}-pxa${PXAV}-embedix${SHARPV}"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2 \
           ftp://ftp.linux.org.uk/pub/armlinux/source/kernel-patches/v2.4/patch-${KV}-rmk${RMKV}.gz;patch=1 \
           ftp://source.mvista.com/pub/xscale/pxa/diff-${KV}-rmk${RMKV}-pxa${PXAV}.gz;patch=1 \
           http://openzaurus.org/mirror/linux-${PV}-slc860-${SHARPV}-rom1_10.bz2;patch=1 \
           file://piro.patch;patch=1 \
           file://swap-performance.patch;patch=1 \
           file://bluetooth-2.4.18-mh15.patch;patch=1 \
           file://iw_handlers.w13-5.diff;patch=1 \
           file://iw_handlers.w14-5.diff;patch=1 \
           file://iw240_we15-6.diff;patch=1 \
           file://iw249_we16-6.diff;patch=1 \
           file://iw249_we17-13.diff;patch=1 \
           file://iw240_we18-5.diff;patch=1 \
           file://bt950_cs.patch;patch=1 \
           file://bluecard_cs.patch;patch=1 \
           file://sharpsl_battery.patch;patch=1 \
           file://buffered-fbmem.patch;patch=1 \
           file://enable-sysrq.patch;patch=1 \
           file://compile.patch;patch=1 \
           file://idecs.patch;patch=1 \
           file://logo.patch;patch=1 \
           file://initsh.patch;patch=1 \
           file://keyboard-ctrl+alt.patch;patch=1 \
           file://keymap-more-sane.patch;patch=1 \
           file://mkdep.patch;patch=1 \
           file://disable-pcmcia-probe.patch;patch=1 \
           file://deviceinfo.patch;patch=1 \
           file://linux-2.4.18-list_move.patch;patch=1 \
           file://tosa_map.patch;patch=1 \
           file://tosa_ts.patch;patch=1 \
           file://corgi-fbcon-logo.patch;patch=1 \
           file://corgi-default-brightness.patch;patch=1 \
           http://www.openswan.org/download/old/openswan-2.2.0-kernel-2.4-klips.patch.gz;patch=1 \
           file://1764-1.patch;patch=1 \
           file://module_licence.patch;patch=1 \
           file://ir240_sys_max_tx-2.diff;patch=1 \
           file://ir241_qos_param-2.diff;patch=1 \
           http://us1.samba.org/samba/ftp/cifs-cvs/cifs-1.20c-2.4.tar.gz \
           file://fix_tosa_apm.patch;patch=1 \
           file://dumb-hack-for-wlan-ng.patch;patch=1 \
           file://unb0rk-apm.patch;patch=1 \
           file://apm_arrowkey.patch;patch=1 \
           file://defconfig-${MACHINE} "

SRC_URI_append_poodle += " file://smallfonts.diff;patch=1"
SRC_URI_append_poodle255 += " file://smallfonts.diff;patch=1"
# apply this when we have a kernel that builds with gcc 3.x:
# SRC_URI_append = file://machtune-args.patch;patch=1
SRC_URI_append_tosa = " file://tosa-power-key-off.patch;patch=1"

S = "${WORKDIR}/linux"

inherit kernel

#
# Create the kernel command line. CMDLINE_CONSOLE is set through kernel.oeclass.
#
CMDLINE_MTDPARTS_poodle   = "mtdparts=sharpsl-nand:7168k@0k(smf),22528k@7168k(root),-(home)"
CMDLINE_MTDPARTS_poodle255   = "mtdparts=sharpsl-nand:7168k@0k(smf),22528k@7168k(root),-(home)"
CMDLINE_MTDPARTS_corgi    = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
CMDLINE_MTDPARTS_shepherd = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
CMDLINE_MTDPARTS_husky    = "mtdparts=sharpsl-nand:7168k@0k(smf),54272k@7168k(root),-(home)"
CMDLINE_MTDPARTS_tosa     = "mtdparts=sharpsl-nand:7168k@0k(smf),28672k@7168k(root),-(home) EQUIPMENT=2"

CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 jffs2_orphaned_inodes=delete"
# CMDLINE_INIT = "init=/bin/busybox ash"
CMDLINE_INIT = " "
CMDLINE = "${CMDLINE_MTDPARTS} ${CMDLINE_ROOT} ${CMDLINE_CONSOLE} ${CMDLINE_INIT}"

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
ALLOW_EMPTY = "1"
FILES_kernel-image = ""
EXTRA_OEMAKE = " EMBEDIXRELEASE=-${DISTRO_VERSION}"
KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "(poodle|corgi|shepherd|husky|poodle255|tosa)"
COMPATIBLE_MACHINE = "none"

PARALLEL_MAKE = ""

#
# autoload modules
#
module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_pxa_bi = "below pxa_bi net_fd usbdcore "
module_autoload_pxa_bi = "pxa_bi"

do_configure_prepend() {
        patch -p1 < cifs_24.patch
        install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
        echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}

PACKAGE_ARCH_corgi    = "c7x0"
PACKAGE_ARCH_shepherd = "c7x0"
PACKAGE_ARCH_husky    = "c7x0"
