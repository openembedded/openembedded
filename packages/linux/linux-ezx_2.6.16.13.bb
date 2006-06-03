DESCRIPTION = "2.6 Linux Development Kernel for the Motorola GSM phones A780 and E680"
SECTION = "kernel"
AUTHOR = "Harald Welte and the OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@vanille.de>"
LICENSE = "GPL"
DEPENDS += "quilt-native"
EZX = "ezx6"
PR = "${EZX}-r6"

inherit kernel

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-ezx"
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

##############################################################
# source and patches
#
SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
	   http://people.openezx.org/stefan/patches/patches-2.6.16-2.6.16.13-exz6-symlink-fix.tar.bz2 \
           \
           ${RPSRC}/led_core-r15.patch;patch=1 \
           ${RPSRC}/led_triggers-r14.patch;patch=1 \
           ${RPSRC}/led_trig_timer-r8.patch;patch=1 \
           ${RPSRC}/led_trig_sharpsl_pm-r5.patch;patch=1 \
           ${RPSRC}/led_zaurus-r10.patch;patch=1 \
           ${RPSRC}/led_locomo-r7.patch;patch=1 \
           ${RPSRC}/led_ixp4xx-r2.patch;patch=1 \
           ${RPSRC}/led_tosa-r5.patch;patch=1 \
           ${RPSRC}/led_ide-r6.patch;patch=1 \
           ${RPSRC}/led_nand-r3.patch;patch=1 \
           \
           file://led_ezx-r0.patch;patch=1 \
	   file://touchscreen-fix-r0.patch;patch=1 \
           \
           file://e680-keypad-compile-HACK.patch;patch=1 \
           file://e680-disable-boomer-HACK.patch;patch=1 \
           file://defconfig-a780 \
           file://defconfig-e680"
S = "${WORKDIR}/linux-2.6.16"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY = 1

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680)'

CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 noinitrd"
CMDLINE_ROOT = "root=/dev/mmcblk0p1 rootfstype=ext3 rootdelay=5"
# CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.1.2:192.168.1.10:192.168.1.10:255.255.255.0:ezx:usb0:off"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}"

###############################################################
# module configs specific to this kernel
#
module_autoload_pxaficp_ir = "pxaficp_ir"
module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_ezxpatch() {
	mv ${WORKDIR}/patches ${S} && cd ${S} && quilt push -av
	rm -Rf patches .pc
}

do_configure() {
	mv ${S}/.config harald.config

	if [ ! -e ${WORKDIR}/defconfig-${MACHINE} ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	if [ "${TARGET_OS}" == "linux-gnueabi" ]; then
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
		die "This kernel is too big for your EZX Phone. Please reduce the size of the kernel by making more of it modular."
	fi
}

###############################################################
# put into deploy directory
#
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib	
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
addtask ezxpatch before do_patch after do_unpack
