require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(omapzoom2|omapzoom36x)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.37+2.6.38-rc4"
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"
SRCREV = "903851effc18c216d48492ead5f0a936b4ff6059"

FILESPATHPKG_prepend = "linux-omap-2.6.38:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

PARALLEL_MAKE = ""

SRC_URI_append_omapzoom2 = " file://logo_linux_clut224.ppm \
"
SRC_URI_append_omapzoom36x = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

