SECTION = "kernel"

include nslu2-linksys-kernel_2.4.22.bb

DESCRIPTION = "Unslung kernel for the Linksys NSLU2 device"
MAINTAINER = "NSLU2 Linux <www.nlsu2-linux.org>"
PR = "r16"

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
	    ${UNSLUNG_KERNEL_EXTRA_SRC_URI}"

# file://pl2303.patch;patch=1


FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/unslung-kernel-${PV}', '${FILE_DIRNAME}/nslu2-linksys-kernel-2.4.22', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

python () {
	# Don't build unslung kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'unslung':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}
