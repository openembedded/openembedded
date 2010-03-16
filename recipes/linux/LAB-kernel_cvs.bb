SECTION = "kernel"
DESCRIPTION = "Liux As Bootloader kernelm"
LICENSE = "GPLv2"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"

#!BIG FAT WARNING:
#build this *before* building your real kernel, otherwise external modules will pickup the wrong headers

DEFAULT_PREFERENCE = "-1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h2200"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
	   file://initramfs_list \
           file://defconfig \
           file://greatwall_header \
           file://greatwall_trailer"

S = "${WORKDIR}/kernel26"

inherit kernel

FILES_kernel-image_h2200 = ""
ALLOW_EMPTY_kernel-image_h2200  = "1"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "21"
HHV     = "8"
#

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"

do_configure() {
	if [ `grep EXTRAVERSION Makefile | grep hh | awk '{print $3}' | sed s/-hh//` != ${HHV} ]; then
		die "-hh version mismatch"
	fi

	# Substitute our uid/gid so the initramfs gets the right ownership.
	MY_UID=`id -u`
	MY_GID=`id -g`
	sed -e "s/^CONFIG_INITRAMFS_ROOT_UID.*$/CONFIG_INITRAMFS_ROOT_UID=$MY_UID/" \
	    -e "s/^CONFIG_INITRAMFS_ROOT_GID.*$/CONFIG_INITRAMFS_ROOT_GID=$MY_GID/" \
	     ${WORKDIR}/defconfig > ${S}/.config

	install -m 0644 ${WORKDIR}/initramfs_list ${S}/initramfs_list

        yes '' | oe_runmake oldconfig
}

KERNEL_IMAGE_BASE_NAME = "LAB-image-${MACHINE}-${DATETIME}.bin"
KERNEL_IMAGE_SYMLINK_NAME =  "LAB-image-${MACHINE}^"

do_deploy_append() {
	# Generate the HTC flavor, which must be a multiple of 512 bytes long.
	cat ${WORKDIR}/greatwall_header arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${WORKDIR}/greatwall_trailer | dd conv=sync of=${DEPLOY_DIR_IMAGE}/LAB-image-${MACHINE}.htc
}

do_stage() {
}
