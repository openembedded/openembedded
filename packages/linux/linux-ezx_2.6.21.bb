DESCRIPTION = "2.6 Linux Development Kernel for the Motorola GSM phones A780 and E680"
SECTION = "kernel"
AUTHOR = "Harald Welte and the OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
LICENSE = "GPL"
EZX = "ezxdev"
PR = "${EZX}-r12"

inherit kernel

require linux.inc

SRC_URI = " \
	${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://logo_linux_clut224.ppm \
        \
	file://patches/patch-2.6.21.4;patch=1 \
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
        file://patches/a780-emu.patch;patch=1 \
        file://patches/e680-emu.patch;patch=1 \
	file://patches/ezx-mtd-map.patch;patch=1 \
	file://patches/ezx-serial-bug-workaround.patch;patch=1 \
	file://patches/pxa-kbd.patch;patch=1 \
	file://patches/a780-kbd.patch;patch=1 \
	file://patches/e680-kbd.patch;patch=1 \
	file://patches/pcap-ts.patch;patch=1 \
	file://patches/a780-ts.patch;patch=1 \
	file://patches/e680-ts.patch;patch=1 \
	file://patches/a1200-ts.patch;patch=1 \
	file://patches/e6-ts.patch;patch=1 \
        file://patches/ezx-eoc.patch;patch=1 \
        file://patches/a1200-eoc.patch;patch=1 \
	file://patches/e6-eoc.patch;patch=1 \
	file://patches/ezx-backlight.patch;patch=1 \
	file://patches/a780-flip.patch;patch=1 \
	file://patches/e680-locksw.patch;patch=1 \
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
        file://defconfig \
        \
	"

S = "${WORKDIR}/linux-${PV}"


##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY  = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a1200|rorkre2|rokre6)'

# For now the code for serial console is disabled in compress.c
#CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 "
CMDLINE_CON = "console=tty1 "

CMDLINE_ROOT = "root=/dev/mmcblk0p1 rootfstype=ext3 rootdelay=5"
# uncomment if you want to boot over NFS
#CMDLINE_ROOT = "root=301 root=/dev/nfs nfsroot=192.168.0.200:/export/ezx-image rootdelay=5 "
# uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.0.202:192.168.0.200:192.168.0.200:255.255.255.0"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} mem=32M@0xA0000000 mem=16M@0xAC000000"

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

###############################################################
# check the kernel is below the 1024*1024 byte limit for the boot-over usb
#
do_compile_append() {
	size=`ls -l arch/${ARCH}/boot/${KERNEL_IMAGETYPE} | awk '{ print $5}'`
	if [ $size -ge 1294336 ]; then
		rm arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
		echo "Size is $size"
		echo  "This kernel is too big for your EZX Phone. Please reduce the size of the kernel by making more of it modular."
	fi
}

