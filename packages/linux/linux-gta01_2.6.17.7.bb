DESCRIPTION = "2.6 Linux Development Kernel for FIC GTA01"
SECTION = "kernel"
AUTHOR = "Harald Welte <hwelte@hmw-consulting.de>"
HOMEPAGE = "N/A"
LICENSE = "GPL"
DEPENDS += "uboot-gta01"
PR = "r4"

inherit kernel

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-gta01"
HWSRC = "http://people.gta01.hmw-consulting.de/laforge/src/kernel/20060806"

##############################################################
# source and patches
#
SRC_URI = "http://people.gta01.hmw-consulting.de/laforge/tmp/linux-2.6.17.7-gta01-lcm.tar.bz2 \
           file://defconfig-${MACHINE}"
S = "${WORKDIR}/linux-2.6.17.7-new"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

COMPATIBLE_MACHINE = 'fic-gta01'

CMDLINE_CON = "console=ttySAC0,115200n8"
#CMDLINE_ROOT = "root=/dev/mmcblk0p1 rootfstype=ext3 rootdelay=5"
# uncomment if you want to boot over NFS
#CMDLINE_ROOT = "root=/dev/nfs nfsroot=192.168.1.10:/export/opie-image rootdelay=5 3"
# uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.1.2:192.168.1.10:192.168.1.10:255.255.255.0:ezx:usb0:off"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}"

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_prepatch() {
        mv ${WORKDIR}/patches ${S}/patches && cd ${S} && quilt push -av
        rm -Rf patches .pc
}

do_configure() {
	#install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm

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
# put into deploy directory and append u-boot header
#
do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
	tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
	arm-linux-objcopy -O binary -R .note -R .comment -S vmlinux linux.bin
	rm -f linux.bin.gz
	gzip -9 linux.bin
	uboot-mkimage -A arm -O linux -T kernel -C gzip -a 30008000 -e 30008000 -n "Kernel Image QT2410" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${MACHINE}-${DATETIME}.bin
	rm -f linux.bin.gz
}

do_deploy[dirs] = "${S}"

addtask prepatch before do_patch after do_unpack
addtask deploy before do_package after do_install

