DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_progear = " \
           file://progear_bl-r6.patch;patch=1 \
	   "

inherit kernel

KERNEL_IMAGETYPE = "bzImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
