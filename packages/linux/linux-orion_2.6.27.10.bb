DESCRIPTION = "Linux Kernel for Marvell Orion based devices"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r1"
DEPENDS = "devio-native"
COMPATIBLE_MACHINE = "(dns323|mv2120|kuropro|lspro|tsx09|ts409)"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://kuropro-foonas-mtd.patch;patch=1 \
           file://fw-and-powerpc-install.patch;patch=1 \
           file://defconfig \
               "

S = "${WORKDIR}/linux-${PV}"

# Fix the mach-type of orion devices
SRC_URI_append_dns323 +=        "file://dns323.patch;patch=1"
SRC_URI_append_mv2120 +=        "file://mv2120.patch;patch=1"
SRC_URI_append_kuropro +=       "file://kuropro.patch;patch=1"
SRC_URI_append_lspro +=         "file://lspro.patch;patch=1"
SRC_URI_append_ts109 +=         "file://ts109-ts209.patch;patch=1"
SRC_URI_append_ts209 +=         "file://ts109-ts209.patch;patch=1"
SRC_URI_append_ts409 +=         "file://ts409.patch;patch=1"

inherit kernel

KERNEL_IMAGETYPE = "uImage"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
