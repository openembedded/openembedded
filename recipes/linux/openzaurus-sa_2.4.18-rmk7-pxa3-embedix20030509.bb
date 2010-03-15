DESCRIPTION = "Linux kernel for OpenZaurus StrongArm processor based devices."
SECTION = "kernel"
PV = "2.4.18-rmk7-pxa3-embedix"
LICENSE = "GPLv2"
KV = "2.4.18"
RMKV = "7"
PXAV = "3"
SHARPV = "20030509"
PR = "r23"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openzaurus-sa-${KV}-rmk${RMKV}-pxa${PXAV}-embedix${SHARPV}"

SRC_URI = "http://www.openzaurus.org/mirror/linux-sl5500-${SHARPV}-rom3_10.tar.bz2 \
           file://cacko.patch;patch=1 \
           file://unb0rk-rightarrow.patch;patch=1 \
           file://unb0rk-apm.patch;patch=1 \
           file://battery.patch;patch=1 \
           file://bluetooth-2.4.18-mh15.patch;patch=1 \
           file://iw_handlers.w13-5.diff;patch=1 \
           file://iw_handlers.w14-5.diff;patch=1 \
           file://iw240_we15-6.diff;patch=1 \
           file://iw249_we16-6.diff;patch=1 \
           file://iw249_we17-13.diff;patch=1 \
           file://iw240_we18-5.diff;patch=1 \
           file://idecs.patch;patch=1 \
           file://logo.patch;patch=1 \
           file://initsh.patch;patch=1 \
           file://keymap-more-sane.patch;patch=1 \
           file://mkdep.patch;patch=1 \
           file://disable-pcmcia-probe.patch;patch=1 \
           file://linux-2.4.18-list_move.patch;patch=1 \
           http://www.openswan.org/download/old/openswan-2.2.0-kernel-2.4-klips.patch.gz;patch=1 \
           file://1764-1.patch;patch=1 \
           file://module_licence.patch;patch=1 \
           file://ir240_sys_max_tx-2.diff;patch=1 \
           file://ir241_qos_param-2.diff;patch=1 \
           file://defconfig-${MACHINE} \
	   "

# that patch allow to use buzzer as sound device but it removes alarms,
# touchclicks etc so it is removed until be fixed
#           file://sound-2.4.18r2.patch;patch=1

# apply this when we have a patch that allows building with gcc 3.x:
# SRC_URI_append = file://gcc-3.3.patch;patch=1
# SRC_URI_append = file://machtune-args.patch;patch=1

S = "${WORKDIR}/linux"

inherit kernel

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

KERNEL_CCSUFFIX = "-2.95"
KERNEL_LDSUFFIX = "-2.11.2"
COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "collie"
COMPATIBLE_MACHINE = "none"

EXTRA_OEMAKE = " EMBEDIXRELEASE=-${DISTRO_VERSION}"

module_conf_usbdmonitor = "alias usbd0 usbdmonitor"
module_conf_sa1100_bi = "below sa1100_bi net_fd usbdcore "
module_autoload_sa1100_bi = "sa1100_bi"
module_autoload_collie_ssp = "collie_ssp"
module_autoload_collie_tc35143af = "collie_tc35143af"
#
# FIXME: Use configuration system
#
export mem = '${@bb.data.getVar("COLLIE_MEMORY_SIZE",d,1) or "32"}'
export rd  = '${@bb.data.getVar("COLLIE_RAMDISK_SIZE",d,1) or "32"}'
export CMDLINE = "${CMDLINE_CONSOLE} root=/dev/mtdblock4 rootfstype=jffs2 jffs2_orphaned_inodes=delete"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."

        mempos=`echo "obase=16; $mem * 1024 * 1024" | bc`
        rdsize=`echo "$rd * 1024" | bc`
        total=`expr $mem + $rd`
        addr=`echo "obase=16; ibase=16; C0000000 + $mempos" | bc`
        if [ "$rd" == "0" ]
        then
                echo "# CONFIG_MTD_MTDRAM_SA1100 is not set" >> ${S}/.config
        else
                echo "CONFIG_MTD_MTDRAM_SA1100=y"           >> ${S}/.config
                echo "CONFIG_MTDRAM_TOTAL_SIZE=$rdsize"     >> ${S}/.config
                echo "CONFIG_MTDRAM_ERASE_SIZE=1"           >> ${S}/.config
                echo "CONFIG_MTDRAM_ABS_POS=$addr"          >> ${S}/.config
        fi
        echo "CONFIG_CMDLINE=\"$CMDLINE mem=${mem}M\"" >> ${S}/.config
}

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-${MACHINE}-${COLLIE_MEMORY_SIZE}-${COLLIE_RAMDISK_SIZE}-${DATETIME}.bin"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-${MACHINE}-${COLLIE_MEMORY_SIZE}-${COLLIE_RAMDISK_SIZE}.bin"
