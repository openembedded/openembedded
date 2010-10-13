require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard"

DEFAULT_PREFERENCE = "-1"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.35+2.6.36-rc7"
MACHINE_KERNEL_PR_append = "d+gitr${SRCREV}"
SRCREV = "67572a62f10351528af72a6ae41129b68aacf1f3"

FILESPATHPKG_prepend = "linux-omap-2.6.36rc:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://0001-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://0002-modedb.c-add-proper-720p60-mode.patch \
                  file://0003-ARM-OMAP-fix-USB-initialization-for-beagleboard-xM.patch \
                  file://0004-ARM-OMAP-Power-on-EHCI-serial-camera-and-DVI-on-beag.patch \
                  file://0005-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://0006-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://0007-OMAP-DSS2-OMAPFB-use-phys_to_virt-for-RAM-mappings.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

