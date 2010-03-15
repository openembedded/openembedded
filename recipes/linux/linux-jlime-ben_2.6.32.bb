DESCRIPTION = "Linux 2.6.32 kernel for the ben nanonote"
SECTION = "kernel"
LICENSE = "GPLv2"

SRCREV = "${AUTOREV}"

DEFAULT_PREFERENCE_ben-nanonote = "1"
COMPATIBLE_MACHINE = "ben-nanonote"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/kristoffer/linux-hpc.git;protocol=git;branch=v2.6.32-hpc"

S = "${WORKDIR}/git"

inherit kernel

ARCH = "mips"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/config-bennanonote ${S}/.config
}