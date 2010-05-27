require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omapzoom"

SRCREV = "26d16dad66b1d3955d8958938f9de5f2e0fce7fb"

#PV = "2.6.27+2.6.28-rc8+${PR}+gitr${SRCREV}"
PV = "2.6.27.10-${PR}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.omapzoom.org/repo/omapkernel.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"



