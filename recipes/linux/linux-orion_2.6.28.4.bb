DESCRIPTION = "Linux Kernel for Marvell Orion based devices"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r0"
COMPATIBLE_MACHINE = "(dns323|mv2120|kuropro|lspro|tsx09|ts409)"

require linux.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.gz;patch=1;name=stablepatch \
           file://kuropro-foonas-mtd.patch;patch=1 \
           file://fw-and-powerpc-install.patch;patch=1 \
           file://defconfig \
               "

S = "${WORKDIR}/linux-2.6.28"

# Fix the mach-type of orion devices - always passed 526
SRC_URI_append_dns323 +=        "file://dns323.patch;patch=1"
SRC_URI_append_mv2120 +=        "file://mv2120.patch;patch=1"
SRC_URI_append_kuropro +=       "file://kuropro.patch;patch=1"
SRC_URI_append_lspro +=         "file://lspro.patch;patch=1"
SRC_URI_append_tsx09 +=         "file://tsx09.patch;patch=1"
SRC_URI_append_ts409 +=         "file://ts409.patch;patch=1"

KERNEL_IMAGETYPE ?= "uImage"

SRC_URI[kernel.md5sum] = "d351e44709c9810b85e29b877f50968a"
SRC_URI[kernel.sha256sum] = "ae0d97c55efe7fce01273c97f8152af0deff5541e3bbf5b9ad98689112b54380"
SRC_URI[stablepatch.md5sum] = "464f663266e2c18371e213adab3c0077"
SRC_URI[stablepatch.sha256sum] = "4862e7bf53553f645d9d730d3657bbec79f7c03482a984259b38e10e25b54382"
