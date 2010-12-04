require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.36+2.6.37-rc4"
MACHINE_KERNEL_PR_append = "b+gitr${SRCREV}"
SRCREV = "a04fd22204b13ce34a3f8a8157f83c44d64f8da9"

FILESPATHPKG_prepend = "linux-omap-2.6.37rc:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://0001-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://0002-modedb.c-add-proper-720p60-mode.patch \
                  file://0003-ARM-OMAP-fix-USB-initialization-for-beagleboard-xM.patch \
                  file://0004-ARM-OMAP-Power-on-EHCI-serial-camera-and-DVI-on-beag.patch \
                  file://0005-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://0006-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://0007-Miracle-patch.patch \
                  file://0008-ARM-OMAP-add-omap_rev_-macros.patch \
                  file://0009-omap-Beagle-detect-new-xM-revision-B.patch \
                  file://0010-OMAP-DSS2-enable-hsclk-in-dsi_pll_init-for-OMAP36XX.patch \
#                  file://0011-omap3-Increase-limit-on-bootarg-mpurate.patch \
                  file://0012-AM37x-Switch-SGX-clocks-to-200MHz.patch \
                  file://0013-ARM-OMAP-Beagle-clarify-CAM_EN-power.patch \
                  file://0014-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

