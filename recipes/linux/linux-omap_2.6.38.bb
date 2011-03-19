require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(omapzoom2|omapzoom36x|beagleboard)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.37+2.6.38-rc8"
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"
SRCREV = "73ee404d7dedd23e35aae3ce516c504db783716f"

FILESPATHPKG_prepend = "linux-omap-2.6.38:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " file://base/0001-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                   file://base/0002-ARM-OMAP-automatically-set-musb-mode-in-platform-dat.patch \
                   file://base/0003-mach-omap2-Makefile-fix-the-security-extensions.patch \
                   file://base/0004-beagleboard-hack-in-support-from-xM-rev-C.patch \
                 "

PARALLEL_MAKE = ""

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"
SRC_URI_append_omapzoom2 = " file://logo_linux_clut224.ppm \
"
SRC_URI_append_omapzoom36x = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

