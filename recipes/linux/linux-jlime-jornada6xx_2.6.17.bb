DESCRIPTION = "JLime Linux kernel for SuperH based Jornada 6xx"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "jornada6xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2 \
           file://defconfig_jlime \
	   file://LinuxSH-2.6.17.patch;patch=0 \
	   file://alsa_hp6xx_2.6.17.patch;patch=0 \
	   file://rtc-2.6.17.patch;patch=0 \
	   file://unexpected-int-fix.patch;patch=0 \
	   file://keymap-fix.patch;patch=0 \
	   file://io.h-fix.patch;patch=0 \
	   file://keyboard-fix-deadkeys.patch;patch=0"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "sh"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig_jlime ${S}/.config
}