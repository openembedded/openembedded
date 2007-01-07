DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2 \
           file://defconfig"

SRC_URI_append_progear = " \
           file://progear_bl-r5.patch;patch=1 \
	   "

S = "${WORKDIR}/linux-2.6.19"

inherit kernel

KERNEL_IMAGETYPE = "bzImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
