SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for Arm based Jornada 7xx"
LICENSE = "GPLv2"
PR = "r0"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "jornada7xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.gz \
           file://defconf_jlime \
	   file://AsmArm-ArchSa1100-Jornada720.patch;apply=yes \
	   file://Cpu-Sa1110-Jornada720.patch;apply=yes \
	   file://Kconfig-Arch-Jornada720.patch;apply=yes \
	   file://Kconfig-Keyboard-Jornada720.patch;apply=yes \
	   file://Kconfig-Touchscreen-Jornada720.patch;apply=yes \
	   file://Kconfig-Video-Jornada720.patch;apply=yes \
	   file://Mach-Sa1100-Jornada720.patch;apply=yes \
	   file://Makefile-Keyboard-Jornada720.patch;apply=yes \
	   file://Makefile-Touchscreen-Jornada720.patch;apply=yes \
	   file://Makefile-Video-Jornada720.patch;apply=yes \
	   file://Newfile-Epson1356fb.patch;apply=yes \
	   file://Newfile-Jornada720_kbd.patch;apply=yes \
	   file://Newfile-Jornada720_ts.patch;apply=yes"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "arm"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconf_jlime ${S}/.config
}

SRC_URI[md5sum] = "3ee4dae7b648e9c290f16fcfb368dbb0"
SRC_URI[sha256sum] = "2346f9ce5dfd8b69760b9148d9bbf835cc6b01f6076e00cb412bfb3a2e3b0064"
