SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPLv2"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE ?= "(asus620|asus730|aximx50|aximx50v|eseries|h1910|h2200|h3600|h3800|h3900|h4000|h5000|htcalpine|htcapache|htcblueangel|htchermes|htchimalaya|htcsable|htcuniversal|htcwallaby|hx4700|ghi270|looxc550|jornada56x|magician|rx1950|rx3000)"

# SRC_URI *must* be overriden in includer, but this is a good reference
SRC_URI ?= "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://24-hostap_cs_id.diff;patch=1 \
           file://hrw-pcmcia-ids-r2.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/kernel26"

inherit kernel


K_MAJOR ?= "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[0]}"
K_MINOR ?= "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[1]}"
K_MICRO ?= "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[2]}"
HHV     ?= "${@bb.data.getVar('PV',d,1).split('-')[1].split('hh')[-1]}"

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"

do_configure() {

	if [ `grep EXTRAVERSION Makefile | grep hh | awk '{print $3}' | sed s/-hh//` != ${HHV} ]; then
		die "-hh version mismatch"
	fi

	rm -f ${S}/.config

	if [ ! -e ${WORKDIR}/defconfig ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	if [ -n "${KERNEL_INITRAMFS_PATH}" -a "${ANGSTROMLIBC}" = "glibc" ]; then
		if [ ! -f ${KERNEL_INITRAMFS_PATH} ]; then
		    echo "Kernel is requested to be built with internal initramfs."
		    echo "The initramfs image must exist prior to building the kernel, but it does not"
		    echo "exist at the specified path ${KERNEL_INITRAMFS_PATH}. You may need to bitbake"
		    echo "it separately, possibly, with a different set of bitbake options. Please"
		    echo "consult documentation for your distro."
		    exit 1
		fi

		# Kernel expects non-compressed cpio
		gzip -d -c ${KERNEL_INITRAMFS_PATH} >${WORKDIR}/initramfs.cpio
		echo "CONFIG_INITRAMFS_SOURCE=\"${WORKDIR}/initramfs.cpio\"" >> ${S}/.config
	fi

	if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then
		echo "CONFIG_AEABI=y"                   >> ${S}/.config
		echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
	else
		echo "# CONFIG_AEABI is not set"        >> ${S}/.config
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

	sed 	-e '/CONFIG_AEABI/d' \
		-e '/CONFIG_OABI_COMPAT=/d' \
		-e '/CONFIG_INITRAMFS_SOURCE=/d' \
		'${WORKDIR}/defconfig' >>'${S}/.config'

	yes '' | oe_runmake oldconfig

}

do_deploy_append() {
	#reflash.ctl is required to reflash using bootldr
	# format:
	# name file md5sumfile destination
	echo "${MACHINE}-kernel-${DATETIME} ${KERNEL_IMAGE_BASE_NAME} - kernel" >> ${DEPLOY_DIR_IMAGE}/reflash.ctl
	gen_haret_startup

	if [ -n "${KERNEL_INITRAMFS_PATH}" -a "${ANGSTROMLIBC}" == "glibc" ]; then
		cp ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-$(basename ${KERNEL_INITRAMFS_PATH} | awk -F. '{print $1}')-${PV}-${PR}-${MACHINE}.bin 
	fi
}   
   

gen_haret_startup() {
	cat >${DEPLOY_DIR_IMAGE}/startup.txt <<EOF 
# This is startup file for HaRET, Linux bootloader for WinCE
# http://handhelds.org/wiki/HaRET

set kernel "${KERNEL_IMAGE_BASE_NAME}.bin"

# Boot choices. Uncomment 'set' statements in exactly one section

## Choice 1 - Boot from SD/MMC card
# Have 2 partition on a card:
# 1st - FAT with HaRET executable, this file and zImage above
# 2nd - EXT2 with rootfs tarball extracted
set cmdline "root=/dev/mmcblk0p2 rootdelay=10 console=ttyS0,115200n8 console=tty0"

## Choice 2 - Boot from CF card, setup like above
#set cmdline "root=/dev/hda2 rootdelay=10 console=ttyS0,115200n8 console=tty0"

## Choice 3 - Boot kernel with builtin interactive bootloader (initramfs-bootmenu-image)
# rootdelay is a wait before scanning for the available partitions
# if root= is also specified, interactive selection will be skipped and
# direct boot will happen.
#set cmdline "rootdelay=3 console=ttyS0,115200n8 console=tty0"

## Choice 4 - Boot rootfs image as initramfs (works only for smaller images)
# have a cpio.gz file below together with zImage, no EXT2 partition required
#set initrd "<image>.rootfs.cpio.gz"
#set cmdline "rdinit=/sbin/init console=ttyS0,115200n8 console=tty0"

## Choice 5 - Boot via NFS over USB networking (must be kernel-builtin
# or initramfs-*-image works too)
# 192.168.x.x - Server address (the other side)
# 192.168.y.y - Handheld's address
#set cmdline "root=/dev/nfs nfsroot=192.168.x.x:<nfs_path> ip=192.168.y.y:192.168.x.x:192.168.x.x:255.255.255.0:pda:usb0 console=ttyS0,115200n8 console=tty0"

## Choice 6 - Boot from MTD partition, for devices with lots of flash
#  to have both WinCE and Linux there. Note the value of root param,
#  that's how it should be, not "/dev/mtdblockN".
#set cmdline "root=mtdN console=ttyS0,115200n8 console=tty0"

bootlinux
EOF
}
