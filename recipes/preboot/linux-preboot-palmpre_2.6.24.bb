require linux-preboot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_palmpre = "-1"

# Hacks should clearly named and at the bottom
SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2;name=kernel \
           "

SRC_URI_append_palmpre = "\
http://palm.cdnetworks.net/opensource/1.3.1/linuxkernel-2.6.24-patch.gz;patch=1;name=patch \
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
SRC_URI[patch.md5sum] = "651e9c518db317d11ae5b9076fb0e3ee"
SRC_URI[patch.sha256sum] = "f9c0327a9fa379f2db6bf4b599bd1e37b65e7224aa3fd2bd860a5e0dc5b06040"
