DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_progear = " \
           file://progear_bl-r6.patch;patch=1 \
	   "
SRC_URI_append_simpad = "\
           file://linux-2.6.20.SIMpad.mq200.patch;patch=1 \
           file://linux-2.6.20.SIMpad.ucb1x00-switches.patch;patch=1 \
	   "

inherit kernel

KERNEL_IMAGETYPE = "bzImage"
KERNEL_IMAGETYPE_simpad = "zImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
