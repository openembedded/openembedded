SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for Arm based Jornada 7xx"
LICENSE = "GPLv2"
PR = "r0"

SRCREV="7ee4a9696f324ee5b721904b24591ed7b8ab6504"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "jornada7xx"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/kristoffer/linux-hpc.git;protocol=git;branch=v2.6.37-hpc"

S = "${WORKDIR}/git"

inherit kernel

ARCH = "arm"

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/configs/jornada720_defconfig ${S}/.config
}
