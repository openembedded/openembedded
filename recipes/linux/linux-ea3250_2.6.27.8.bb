SECTION = "kernel"
DESCRIPTION = "Linux kernel for the EmbeddedArtists LPC3250 development board"
HOMEPAGE = "http://embeddedartists.com"
# DEPENDS = ""
LICENSE = "GPL"
PR = "r0"

# Location of the base kernel and NXP's patches

# It is advisable to mirror the patches listed below, as there is no certainty
# that they will stay there indefinitely.
#  - Joost
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.27.8.tar.bz2 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-update1.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update2.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update3.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_armtskit_update2.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_ea3250.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update4.patch;patch=1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update5.patch;patch=1 \
	file://kernel-arm-2.6.27.8-lpc32xx_update5_fix.patch;patch=1 \
	file://lpc32xx-spwm.patch;patch=1 \
	file://defconfig"

# Source directory
S = "${WORKDIR}/linux-${PV}"

# Which machines are supported by this kernel
COMPATIBLE_HOST = 'arm.*-linux'

# Kernel object suffix (should be .o)
KERNEL_OBJECT_SUFFIX = ".o"

# Inherit the class that actually builds the kernel
inherit kernel

# Kernel command line
# XXX
CMDLINE = "root=/dev/mmcblk0p2 console=ttyS0,115200"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

COMPATIBLE_MACHINE = "ea3250"
