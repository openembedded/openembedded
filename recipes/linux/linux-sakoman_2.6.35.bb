require linux-sakoman.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3-multi|overo|omap4-multi|omap4430-panda|omap4430-sdp"

PV = "2.6.35"

S = "${WORKDIR}/git"
SRCREV = ${AUTOREV}
SRC_URI = "git://www.sakoman.com/git/linux-omap-2.6.git;branch=omap3-2.6.35;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

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

SRCREV_omap4-multi = "6d019dae0034f66141cdeb355e2ffc71582f4131"
SRC_URI_omap4-multi = "git://www.sakoman.com/git/kernel-omap4.git;branch=L24.9;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

