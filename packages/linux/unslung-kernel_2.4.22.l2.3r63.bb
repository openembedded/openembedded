SECTION = "kernel"

include nslu2-linksys-kernel_2.4.22.bb

DESCRIPTION = "Unslung kernel for the Linksys NSLU2 device"
MAINTAINER = "NSLU2 Linux <www.nlsu2-linux.org>"
PR = "r3"

KERNEL_SUFFIX = "unslung"

CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 rw init=/linuxrc mem=32M@0x00000000"

UNSLUNG_KERNEL_EXTRA_SRC_URI ?=

SRC_URI += "file://limit1gb.patch;patch=1 \
	    file://gl811e.patch;patch=1 \
	    file://ext3flash-on-disk1.patch;patch=1 \
	    file://usbnet.patch;patch=1 \
	    file://missing-usb-ioctls.patch;patch=1 \
	    file://anonymiser.patch;patch=1 \
	    file://ppp_mppe.patch;patch=1 \
	    file://nfs-blocksize.patch;patch=1 \
	    file://pl2303.patch;patch=1 \
	    file://linux-kernel-R25_to_R29.patch;patch=1 \
	    ${UNSLUNG_KERNEL_EXTRA_SRC_URI}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/unslung-kernel', '${FILE_DIRNAME}/nslu2-linksys-kernel-2.4.22', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

python () {
	# Don't build unslung kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}

DEPENDS += "nslu2-linksys-firmware"

do_deploy_append() {
	cp ${STAGING_LIBDIR}/nslu2-binaries/vmlinuz ${WORKDIR}/vmlinuz
	dd if=${WORKDIR}/vmlinuz bs=1 count=11732 > ${WORKDIR}/vmlinuh
	dd if=${WORKDIR}/vmlinuz bs=1 skip=11732 count=975109 | gzip -dc > ${WORKDIR}/vmlinux
	dd if=${WORKDIR}/vmlinuz bs=1 skip=986841 > ${WORKDIR}/vmlinut
	cat ${WORKDIR}/vmlinux | sed \
		-e 's/ram0/slug/' \
		-e 's/\x01\x31\x2c\xff/\x00\x1e\x84\x7f/' \
			| gzip -9 -c > ${WORKDIR}/vmlinux.gz
#		-e 's/flash_sda\x00/hdd_sda\x00\x00\x00/' \
# 		-e 's/flash_\x00/hdd_\x00\x00\x00/' \
#		-e 's/flash_sd%c\x00/hdd_sd%c\x00\x00\x00/' \
	cat ${WORKDIR}/vmlinuh ${WORKDIR}/vmlinux.gz ${WORKDIR}/vmlinut > ${WORKDIR}/vmlinuz
#	dd if=/dev/zero of=${WORKDIR}/padding bs=1 count=9
#	cat ${WORKDIR}/vmlinuh ${WORKDIR}/vmlinux.gz ${WORKDIR}/padding ${WORKDIR}/vmlinut > ${WORKDIR}/vmlinuz
        install -d ${DEPLOY_DIR}/images
        install -m 0644 ${WORKDIR}/vmlinuz ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}
}
