SECTION = "kernel"
DESCRIPTION = "Linux kernel for the EmbeddedArtists LPC3250 development board"
HOMEPAGE = "http://embeddedartists.com"
# DEPENDS = ""
LICENSE = "GPLv2"
PR = "r0"

# Location of the base kernel and NXP's patches

# It is advisable to mirror the patches listed below, as there is no certainty
# that they will stay there indefinitely.
#  - Joost
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.27.8.tar.bz2;name=kernel \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx.patch;patch=1;name=patch1 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-update1.patch;patch=1;name=patch2 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update2.patch;patch=1;name=patch3 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update3.patch;patch=1;name=patch4 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_armtskit_update2.patch;patch=1;name=patch5 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_ea3250.patch;patch=1;name=patch6 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update4.patch;patch=1;name=patch7 \
	http://bitshrine.org/gpp/kernel-arm-2.6.27.8-lpc32xx_update5.patch;patch=1;name=patch8 \
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

SRC_URI[kernel.md5sum] = "cbdc1b350ef79dd323b9aeda5cf7f1b6"
SRC_URI[kernel.sha256sum] = "330aa3059309c589c3abb2d743e5f391dac6671b75004dccde32b54ade17f05d"
SRC_URI[patch1.md5sum] = "165364e207bd2e122d9f5e7d94a683eb"
SRC_URI[patch1.sha256sum] = "897b6d576526c305b0e8b4a3d1cd02f334606429aacf4969094925cd321c5a3b"
SRC_URI[patch2.md5sum] = "7533dc7dda4d8ff56dfa25b202632dff"
SRC_URI[patch2.sha256sum] = "ff46bb7501f23c331b1ba6057ff2eab56690d9cb39a67f92ee7261bdd0947881"
SRC_URI[patch3.md5sum] = "59f8fafa796bcbe6367c4f10ef8d9491"
SRC_URI[patch3.sha256sum] = "96153e5b741c2ef4157c22aef9e1a6f1b91a796f3a646bdfb21bc3adbb4fe4b3"
SRC_URI[patch4.md5sum] = "2675cd2b70baad7ecc9fb5f64dc1854b"
SRC_URI[patch4.sha256sum] = "b1528917ec3d9fc784173795838bf413761b15f5381b6c5885b27b96af418659"
SRC_URI[patch5.md5sum] = "4074fe1f0af60b416e73ab4754dd59b3"
SRC_URI[patch5.sha256sum] = "17c543853daed8f99d6a721a34c509aea262d6868d7680fe808971b401fe5761"
SRC_URI[patch6.md5sum] = "38af08bbd067ef50a9e09c64840e56db"
SRC_URI[patch6.sha256sum] = "52cbdf4307c270a6396008a30c32c9012d155a7b0cf26a8430bda3632bee8f7d"
SRC_URI[patch7.md5sum] = "2f21f8455945759a5af8060224f2a1e2"
SRC_URI[patch7.sha256sum] = "14a15c6c8080189066d4e5914e365c5f0253a1578008ced42d7e32746e6f4666"
SRC_URI[patch8.md5sum] = "e65e51b0d8b5710a270fce38f1c6b05b"
SRC_URI[patch8.sha256sum] = "2d323344b949de7ad5fb783136a1e6093d616f0a0fe5f7f79c4f1aa6c1869c6f"
