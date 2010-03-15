SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for Arm based Jornada 7xx"
LICENSE = "GPLv2"
PR = "r0"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "jornada7xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.gz \
           file://defconf_jlime \
	   file://AsmArm-ArchSa1100-Jornada720.patch;patch=0 \
	   file://Cpu-Sa1110-Jornada720.patch;patch=0 \
	   file://Kconfig-Arch-Jornada720.patch;patch=0 \
	   file://Kconfig-Keyboard-Jornada720.patch;patch=0 \
	   file://Kconfig-Touchscreen-Jornada720.patch;patch=0 \
	   file://Kconfig-Video-Jornada720.patch;patch=0 \
	   file://Mach-Sa1100-Jornada720.patch;patch=0 \
	   file://Makefile-Keyboard-Jornada720.patch;patch=0 \
	   file://Makefile-Touchscreen-Jornada720.patch;patch=0 \
	   file://Makefile-Video-Jornada720.patch;patch=0 \
	   file://Newfile-Epson1356fb.patch;patch=0 \
	   file://Newfile-Jornada720_kbd.patch;patch=0 \
	   file://Newfile-Jornada720_ts.patch;patch=0"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "arm"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconf_jlime ${S}/.config
}
