require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.36+2.6.37-rc5"
MACHINE_KERNEL_PR_append = "c+gitr${SRCREV}"
SRCREV = "2fc4a8a62495f4f72d91c62340443e409be8f448"

FILESPATHPKG_prepend = "linux-omap-2.6.37rc:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://0001-ARM-OMAP-Power-on-EHCI-serial-camera-and-DVI-on-beag.patch \
                  file://0002-omap-Beagle-detect-new-xM-revision-B.patch \
                  file://0003-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://0004-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
                  file://0005-modedb.c-add-proper-720p60-mode.patch \
                  file://0006-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://0007-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://0008-Miracle-patch.patch \
                  file://0009-ARM-OMAP-add-omap_rev_-macros.patch \
                  file://0010-OMAP-DSS2-enable-hsclk-in-dsi_pll_init-for-OMAP36XX.patch \
                  file://0011-AM37x-Switch-SGX-clocks-to-200MHz.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

