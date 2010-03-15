SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for SuperH based Jornada 6xx"
LICENSE = "GPLv2"
PR = "r0"

COMPATIBLE_HOST = "sh.*-linux"
#COMPATIBLE_MACHINE = "jornada6xx"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;tag=v2.6.21-rc5 \
           file://git-20070405-2.patch;patch=1 \
           file://hp6xx-IRQ3.patch;patch=1 \
	   file://defconfig"
	   

S = "${WORKDIR}/git"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "sh"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
