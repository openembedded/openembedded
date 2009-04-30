require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omapzoom"

SRCREV = "26d16dad66b1d3955d8958938f9de5f2e0fce7fb"

#PV = "2.6.27+2.6.28-rc8+gitr${SRCPV}"
PV = "2.6.27.10+gitr${SRCPV}"
PR = "r0"
PE = "1"

SRC_URI = "git://git.omapzoom.org/repo/omapkernel.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"



