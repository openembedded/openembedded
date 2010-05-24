require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm"

SRCREV = "2a3408be17f287fdb5809c9b6c68e7ad96d25b74"
PR = "r14"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
           file://no-empty-flash-warnings.patch \
           file://oprofile-0.9.3.armv7.diff \
           file://no-cortex-deadlock.patch \
           file://read_die_ids.patch \
           file://fix-install.patch \
           file://musb-dma-iso-in.eml;apply=yes \
           file://musb-support-high-bandwidth.patch.eml;apply=yes \
           file://mru-fix-timings.diff \
           file://mru-fix-display-panning.diff \
           file://mru-make-dpll4-m4-ck-programmable.diff \
           file://mru-add-clk-get-parent.diff \
           file://mru-improve-pixclock-config.diff \
           file://mru-make-video-timings-selectable.diff \
           file://mru-enable-overlay-optimalization.diff \
           file://musb-fix-ISO-in-unlink.diff \
           file://musb-fix-multiple-bulk-transfers.diff \
           file://musb-fix-endpoints.diff \
           file://dvb-fix-dma.diff \
           file://0001-Removed-resolution-check-that-prevents-scaling-when.patch \
           file://0001-Implement-downsampling-with-debugs.patch \
#           file://openvz/0001-arm-introduce-MAP_EXECPRIO-define.patch \
#           file://openvz/0002-arm-export-arm-version-of-show_mem.patch \
#           file://openvz/0003-arm-wire-OpenVZ-syscalls.patch \
#           file://openvz/0004-arm-add-openvz-and-bc-Kconfigs.patch \
#           file://openvz/openvz-2.6.27.diff \
           file://sitecomwl168-support.diff \
           file://nand.patch \
           file://musb-rxtx.patch \
           file://add-gwc.diff \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
			     "

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


