require linux.inc

DESCRIPTION = "Linux kernel for Palm Pre. Original version of Palm, Inc."
KERNEL_IMAGETYPE = "uImage"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           http://palm.cdnetworks.net/opensource/1.1.0/linux-2.6.24-patch.gz;patch=1;name=patch \
           "

S = "${WORKDIR}/linux-2.6.24"

# We try to build the identical kernel as Palms here, use their defconfig.
do_configure_prepend() {
        install -m 0644 ${S}/arch/arm/configs/omap_sirloin_3430_defconfig ${WORKDIR}/defconfig
}

# linux.inc overrides LOCAVERSION but we like to stay with the one used originally
do_compile_prepend() {
	sed -i -e '/CONFIG_LOCALVERSION=/d' ${S}/.config
	echo 'CONFIG_LOCALVERSION="-joplin-3430"' >>${S}/.config
}

SRC_URI[kernel.md5sum] = "3f23ad4b69d0a552042d1ed0f4399857"
SRC_URI[kernel.sha256sum] = "413c64fbbcf81244cb5571be4963644a1e81166a2b0f008a016528363b65c5d3"
SRC_URI[patch.md5sum] = "1c5547aa497a7eae9fa52ed4df4b0f11"
SRC_URI[patch.sha256sum] = "5f7c232f9216ce45f0ab0045098cd2b21b6f2f8a7668bffd2e06040a5b87ba84"
