DESCRIPTION = "Linux 2.6.32 kernel for the SuperH-based Jornada 6xx"
SECTION = "kernel"
LICENSE = "GPL"

SRCREV = "${AUTOREV}"

COMPATIBLE_MACHINE = "jornada6xx"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/kristoffer/linux-hpc.git;protocol=git;branch=v2.6.32-hpc"

S = "${WORKDIR}/git"

inherit kernel

ARCH = "sh"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/config-hp6xx ${S}/.config
}