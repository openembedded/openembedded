SECTION = "kernel"

include nslu2-linksys-kernel_2.4.22.bb

DESCRIPTION = "Unslung kernel for the Linksys NSLU2 device"
MAINTAINER = "NSLU2 Linux <www.nlsu2-linux.org>"
PR = "r13"

KERNEL_SUFFIX = "unslung"

CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 rw init=/linuxrc mem=32M@0x00000000"

UNSLUNG_KERNEL_EXTRA_SRC_URI ?=

SRC_URI += "file://linux-kernel-R25_to_R29.patch;patch=1 \
	    file://linux-kernel-R29_to_R63.patch;patch=1 \
	    file://flash-is-now-hdd.patch;patch=1 \
	    file://gl811e.patch;patch=1 \
	    file://usbnet.patch;patch=1 \
	    file://missing-usb-ioctls.patch;patch=1 \
	    file://anonymiser.patch;patch=1 \
	    file://ppp_mppe.patch;patch=1 \
	    file://nfs-blocksize.patch;patch=1 \
	    file://pl2303.patch;patch=1 \
	    file://pl2303_mdmctl.patch;patch=1 \
	    file://netconsole.patch;patch=1 \
	    file://ppp_mppe_no_fp_in_kernel.patch;patch=1 \
	    ${UNSLUNG_KERNEL_EXTRA_SRC_URI}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/unslung-kernel', '${FILE_DIRNAME}/nslu2-linksys-kernel-2.4.22', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

COMPATIBLE_MACHINE = "nslu2"
