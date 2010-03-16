DESCRIPTION = "Linux Kernel for the QNAP TurboStation platform"
SECTION = "kernel"
LICENSE = "GPLv2"
DEPENDS = "u-boot-utils-native"
PR = "r2"

COMPATIBLE_MACHINE = "turbostation"

RDEPENDS_kernel-module-zd1211rw += "zd1211-firmware"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://001_r1000.diff;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.h;patch=1 \
	file://002_qnap-pic.diff;patch=1 \
	file://linux-2.6.16_arch_ppc_syslib_Makefile;patch=1 \
	file://linux-2.6.16_drivers_mtd_maps_physmap.c;patch=1 \
	file://linux-2.6.16_arch_ppc_syslib_mpc10x_common.c;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_Makefile;patch=1 \
	file://linux-2.6.16_include_asm-ppc_mpc10x.h;patch=1 \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.c;patch=1 \
	file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "uImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}"
# Override arch. The kernel stuff is in arch/ppc, not arch/powerpc in our case
ARCH = ppc

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make ARCH=ppc oldconfig
}

#ppc build leaves the kernel in a different place
#do_movekernel() {
#
#}
