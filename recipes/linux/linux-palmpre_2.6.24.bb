require linux.inc

DESCRIPTION = "Linux kernel for Palm Pre. Original version of Palm, Inc."
KERNEL_IMAGETYPE = "uImage"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           http://palm.cdnetworks.net/opensource/1.1.0/linux-2.6.24-patch.gz;patch=1 \
           "

S = "${WORKDIR}/linux-2.6.24"

# We try to build the identical kernel as Palms here, use their defconfig.
do_configure_prepend() {
        install -m 0644 ${S}/arch/arm/configs/omap_sirloin_3430_defconfig ${WORKDIR}/defconfig
}
