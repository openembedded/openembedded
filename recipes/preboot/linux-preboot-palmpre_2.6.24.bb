require linux-preboot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_palmpre = "-1"

# Hacks should clearly named and at the bottom
SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           "

SRC_URI_append_palmpre = "\
http://palm.cdnetworks.net/opensource/1.3.1/linuxkernel-2.6.24-patch.gz;patch=1 \
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
