DESCRIPTION = "2.6 Linux Development Kernel for the Motorola GSM phones A780 and E680"
SECTION = "kernel"
AUTHOR = "Harald Welte and the OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
LICENSE = "GPL"
DEPENDS += "quilt-native"
EZX = "ezx0"
PR = "${EZX}-r2"

DEFAULT_PREFERENCE = "-1"


inherit kernel

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-ezx"
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

##############################################################
# source and patches
#
SRC_URI = " \
        ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://ezx-core.patch;patch=1 \
	file://ezx-pcap.patch;patch=1 \
	file://ezx-mci.patch;patch=1 \
 	file://pxa27x-udc-support.2.patch;patch=1 \
	file://ezx-emu.patch;patch=1 \
	file://ezx-mtd-map.patch;patch=1 \
	file://ezx-serial-bug-workaround.patch;patch=1 \
	file://pxa-kbd.patch;patch=1 \
	file://ezx-kbd.patch;patch=1 \
	file://ezx-pm.patch;patch=1 \
	file://mux_cli.patch;patch=1 \
	file://mux-fix.patch;patch=1 \
	file://mux-fix-init-errorpath.patch;patch=1 \
	file://mux-remove-flipbuffers.patch;patch=1 \
	file://mux-remove-get_halted_bit.patch;patch=1 \
	file://mux-remove-usbh_finished_resume.patch;patch=1 \
	file://mux-fix-makefile.patch;patch=1 \
	file://mux-fix-tty-driver.patch;patch=1 \
	file://mux-linux-2.6.21-fix.patch;patch=1 \
	file://mux-ifdef-ezx-features.patch;patch=1 \
	file://mux_debug.patch;patch=1 \
	file://ezx-ts.patch;patch=1 \
	file://pcap_ts.c.patch;patch=1 \
	file://touchscreen-fix-r0.patch;patch=1 \
        file://logo_linux_clut224.ppm \
        file://defconfig-a780 \
        file://defconfig-e680 \
       "

S = "${WORKDIR}/linux-${PV}"


##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY  = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680)'

CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 noinitrd"
CMDLINE_ROOT = "root=/dev/mmcblk0p1 rootfstype=ext3 rootdelay=5"
# uncomment if you want to boot over NFS
#CMDLINE_ROOT = "root=/dev/nfs nfsroot=192.168.1.10:/export/opie-image rootdelay=5 3"
# uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.1.2:192.168.1.10:192.168.1.10:255.255.255.0:ezx:usb0:off"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} mem=32M@0xA0000000 mem=16M@0xAC000000"

###############################################################
# module configs specific to this kernel
#
module_autoload_pxaficp_ir = "pxaficp_ir"
module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_configure() {
	install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm

	if [ ! -e ${WORKDIR}/defconfig-${MACHINE} ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
		echo "CONFIG_AEABI=y"                   >> ${S}/.config
		echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
	else
		echo "# CONFIG_AEABI is not set"        >> ${S}/.config
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

	sed -e '/CONFIG_AEABI/d' \
	    -e '/CONFIG_OABI_COMPAT=/d' \
	    -e '/CONFIG_CMDLINE=/d' \
	    -e '/CONFIG_MTD_MTDRAM_SA1100=/d' \
	    -e '/CONFIG_MTDRAM_TOTAL_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ERASE_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ABS_POS=/d' \
	    '${WORKDIR}/defconfig-${MACHINE}' >>'${S}/.config'

	yes '' | oe_runmake oldconfig
}

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

###############################################################
# put into deploy directory
#
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_VERSION}-${MACHINE}.tgz -C ${D} lib
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
