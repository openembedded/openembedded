DESCRIPTION = "JLime Linux kernel for SuperH based Jornada 6xx"
SECTION = "kernel"
LICENSE = "GPLv2"

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
SRC_URI[md5sum] = "37ddefe96625502161f075b9d907f21e"
SRC_URI[sha256sum] = "ab0f647d52f124958439517df9e1ae0efda90cdb851f59f522fa1749f1d87d58"
