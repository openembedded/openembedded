DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.21-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.21-SIMpad-serial-and-gpio_keys.patch;patch=1 \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.21-pcmcia-device-to-platform-driver.patch;patch=1 \
           "

inherit kernel

KERNEL_IMAGETYPE_simpad = "zImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

