CORTEXA8FIXUP = "no"

require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3-multi|overo|omap4-multi|omap4430-panda|omap4430-sdp"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "2.6.35"

S = "${WORKDIR}/git"

SRCREV_omap4430-panda = "6d019dae0034f66141cdeb355e2ffc71582f4131"
SRC_URI_omap4430-panda = "git://www.sakoman.com/git/kernel-omap4.git;branch=L24.9;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

SRCREV_omap4430-sdp = "6d019dae0034f66141cdeb355e2ffc71582f4131"
SRC_URI_omap4430-sdp = "git://www.sakoman.com/git/kernel-omap4.git;branch=L24.9;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

