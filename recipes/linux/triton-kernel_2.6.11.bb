SECTION = "kernel"
DESCRIPTION = "Linux kernel for the KARO TRITON XScale Board"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/2.6/${PV}/${PV}-mm2/${PV}-mm2.bz2;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "f00fd1b5a80f52baf9d1d83acddfa325"
SRC_URI[kernel.sha256sum] = "1fa39c202efe168bfeb0ddd74c8e4814f77da7dc78993e47826bad9173b95808"
SRC_URI[patch.md5sum] = "47866851bef2af4a3b272936f357e9a4"
SRC_URI[patch.sha256sum] = "bdf362709b120fa027a9e2303a4055169e143d2d16372f7c978f84062c8a8d30"
