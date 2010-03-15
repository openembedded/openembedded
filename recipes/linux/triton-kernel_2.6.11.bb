SECTION = "kernel"
DESCRIPTION = "Linux kernel for the KARO TRITON XScale Board"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/2.6/${PV}/${PV}-mm2/${PV}-mm2.bz2;patch=1 \
		   file://patch-2.6.11-mm2-karo9.bz2;patch=1 \
		   file://defconfig"

S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
CMDLINE ?= "root=/dev/mtdblock2 rw rootfstype=jffs2 reboot=5"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

COMPATIBLE_MACHINE = "triton"
