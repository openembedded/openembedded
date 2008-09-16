require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm"


SRCREV = "de1121fdb899f762"

PV = "2.6.26+2.6.27-rc6+${PR}+git${SRCREV}"
PR = "r4"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
           file://timer-suppression.patch;patch=1 \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://oprofile-0.9.3.armv7.diff;patch=1 \
           file://no-cortex-deadlock.patch;patch=1 \
           file://read_die_ids.patch;patch=1 \
           file://fix-install.patch;patch=1 \
           file://musb-dma-iso-in.eml;patch=1 \
           file://musb-support-high-bandwidth.patch.eml;patch=1 \
           file://musb-mru-otgfix.diff;patch=1 \
           file://mru-fix-timings.diff;patch=1 \
           file://mru-fix-display-panning.diff;patch=1 \
           file://mru-make-dpll4-m4-ck-programmable.diff;patch=1 \
           file://mru-add-clk-get-parent.diff;patch=1 \
           file://mru-improve-pixclock-config.diff;patch=1 \
           file://mru-make-video-timings-selectable.diff;patch=1 \
           file://mru-enable-overlay-optimalization.diff;patch=1 \
           file://strongly-ordered-memory.diff;patch=1 \
"

temporarely-disabled = " \
           file://musb-dmafix.patch;patch=1 \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
                             "

SRC_URI_append_omap3evm = " \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


