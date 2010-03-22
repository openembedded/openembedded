DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

PR = "r1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/v2.6.17-gitcurrent.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/full.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/WIP/serial_sparse.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/WIP/h1940_leds.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/WIP/bluetooth.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/WIP/h1940_batt.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.17-1/WIP/mtd_partition.patch;patch=1 \
           http://anymore.nl/ipaq/usbgadget_fixups.patch;patch=1 \
           http://anymore.nl/ipaq/udc_usb_gadget_register_driver_fix.patch;patch=1 \
           http://anymore.nl/ipaq/udc_unbind.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.17"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}
