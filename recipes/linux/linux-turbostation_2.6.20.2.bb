DESCRIPTION = "Linux Kernel for the QNAP TurboStation platform"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

COMPATIBLE_MACHINE = "turbostation"

RDEPENDS_kernel-module-zd1211rw += "zd1211-firmware"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://001_r1000.diff \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.h;apply=yes \
	file://002_qnap-pic.diff \
	file://linux-2.6.16_arch_ppc_syslib_Makefile;apply=yes \
	file://linux-2.6.16_drivers_mtd_maps_physmap.c;apply=yes \
	file://linux-2.6.16_arch_ppc_syslib_mpc10x_common.c;apply=yes \
	file://linux-2.6.16_arch_ppc_platforms_Makefile;apply=yes \
	file://linux-2.6.16_include_asm-ppc_mpc10x.h;apply=yes \
	file://linux-2.6.16_arch_ppc_platforms_sandpoint.c;apply=yes \
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

SRC_URI[md5sum] = "bc33bd163130df9c59b165a1d31ccfdc"
SRC_URI[sha256sum] = "56c46e51429530665970c53c9a99d8ad3843bb5c0fa713fb752b2724ff4eb872"
