DESCRIPTION = "2.6 Linux Development Kernel for the Motorola GSM phones A780 and E680"
AUTHOR = "The OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
EZX = "ezxdev"
PR = "${EZX}-r24"

require linux.inc

RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

CFLAGS += "-DPATH_MAX=256"

SRC_URI = " \
    ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
    file://logo_linux_clut224.ppm \
    \
    file://patches/patch-2.6.21.4;patch=1 \
    ${RPSRC}/lzo_kernel-r0.patch;patch=1 \
    ${RPSRC}/lzo_jffs2-r0.patch;patch=1 \
    ${RPSRC}/lzo_crypto-r1.patch;patch=1 \
    ${RPSRC}/lzo_jffs2_lzomode-r0.patch;patch=1 \
    ${RPSRC}/lzo_jffs2_sysfs-r0.patch;patch=1 \
    ${RPSRC}/pxa_timerfix-r0.patch;patch=1 \
    ${RPSRC}/pxa27x_overlay-r5.patch;patch=1 \
    ${RPSRC}/pxa-linking-bug.patch;patch=1;status=unmergable \
    ${RPSRC}/mmcsd_large_cards-r0.patch;patch=1;status=hack \
    ${RPSRC}/mmcsd_no_scr_check-r0.patch;patch=1;status=hack \
    file://patches/ezx-core.patch;patch=1 \
    file://patches/ezx-bp.patch;patch=1 \
    file://patches/ezx-pm.patch;patch=1 \
    file://patches/ezx-pcap.patch;patch=1 \
    file://patches/a780-pcap.patch;patch=1 \
    file://patches/e680-pcap.patch;patch=1 \
    file://patches/a1200-pcap.patch;patch=1 \
    file://patches/e6-pcap.patch;patch=1 \
    file://patches/a780-mci.patch;patch=1 \
    file://patches/e680-mci.patch;patch=1 \
    file://patches/a1200-mci.patch;patch=1 \
    file://patches/e6-mci.patch;patch=1 \
    file://patches/pxa27x-udc-support.2.patch;patch=1 \
    file://patches/ezx-emu.patch;patch=1 \
    file://patches/ezx-eoc.patch;patch=1 \ 
    file://patches/a1200-eoc.patch;patch=1 \
    file://patches/e6-eoc.patch;patch=1 \
    file://patches/a780-emu.patch;patch=1 \
    file://patches/e680-emu.patch;patch=1 \
    file://patches/ezx-mtd-map.patch;patch=1 \
    file://patches/ezx-serial-bug-workaround.patch;patch=1 \
    file://patches/pxa-kbd.patch;patch=1 \
    file://patches/a780-kbd.patch;patch=1 \
    file://patches/e680-kbd.patch;patch=1 \
    file://patches/a1200-kbd.patch;patch=1 \
    file://patches/pcap-ts.patch;patch=1 \
    file://patches/a780-ts.patch;patch=1 \
    file://patches/e680-ts.patch;patch=1 \
    file://patches/a1200-ts.patch;patch=1 \
    file://patches/e6-ts.patch;patch=1 \
    file://patches/a780-flip.patch;patch=1 \
    file://patches/e680-locksw.patch;patch=1 \
    file://patches/a1200-flip.patch;patch=1 \
    file://patches/a780-leds.patch;patch=1 \
    file://patches/e680-leds.patch;patch=1 \
    file://patches/a780-vibrator.patch;patch=1 \
    file://patches/mux_cli.patch;patch=1 \
    file://patches/mux-fix.patch;patch=1 \
    file://patches/mux-fix-init-errorpath.patch;patch=1 \
    file://patches/mux-remove-flipbuffers.patch;patch=1 \
    file://patches/mux-remove-get_halted_bit.patch;patch=1 \
    file://patches/mux-remove-usbh_finished_resume.patch;patch=1 \
    file://patches/mux-fix-makefile.patch;patch=1 \
    file://patches/mux-fix-tty-driver.patch;patch=1 \
    file://patches/mux-linux-2.6.21-fix.patch;patch=1 \
    file://patches/asoc-pxa-ssp.patch;patch=1 \
    file://patches/asoc-fix-loopback.patch;patch=1 \
    file://patches/ezx-asoc.patch;patch=1 \     
    file://patches/mtdfix.patch;patch=1 \
    file://patches/ezx-backlight.patch;patch=1 \
    file://defconfig \
    \
    "

S = "${WORKDIR}/linux-${PV}"


##############################################################
# kernel image resides on a seperate flash partition (for now)
# But we can flash it from userspace (flash_unlock /dev/mtdX && flash_eraseall /dev/mtdX && flashcp /boot/zImage /dev/mtdX)
# so lets make a package of it. What about a postinst that flashes the new kernel?

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a1200|rorkre2|rokre6)'

# For now the code for serial console is disabled in compress.c
#CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 "
CMDLINE_CON = "console=tty1 "

CMDLINE_ROOT = "root=/dev/mmcblk0p2 rootfstype=ext2 rootdelay=1"
CMDLINE_NFSROOT = "root=/dev/nfs rootfstype=nfs nfsroot=192.168.0.200:/export/ezx-image rootdelay=1 "
# Uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.0.202:192.168.0.200:192.168.0.200:255.255.255.0"
CMDLINE_MEM = "mem=32M@0xA0000000 mem=16M@0xAC000000"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} ${CMDLINE_MEM}"
# Uncomment to use root-over-nfs-over-usb
#CMDLINE_NFSROOT_USB = "${CMDLINE_CON} ${CMDLINE_NFSROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} ${CMDLINE_MEM}"

# 1024x1024 once was the maximum kernel size for boot-over-usb -- is it still?
#KERNEL_IMAGE_MAXSIZE = "1294336"

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

