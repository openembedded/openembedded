require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omapzoom|omapzoom2|omap4430-sdp"

DEFAULT_PREFERENCE = "-1"

SRCREV = "945044d157dd63c6af0f2ed40a5346382af94eb4"

FILESPATHPKG_prepend = "linux-omap-2.6.31:"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
#PV = "2.6.30+2.6.31-rc8+gitr${SRCREV}"
PV = "2.6.31"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://ehci.patch \
                  file://0001-implement-TIF_RESTORE_SIGMASK-support-and-enable-the.patch \
                  file://cache/l1cache-shift.patch \
                  file://cache/copy-page-tweak.patch \
                  file://dss2/0001-OMAP2-Add-funcs-for-writing-SMS_ROT_-registers.patch \
                  file://dss2/0002-OMAP-OMAPFB-split-omapfb.h.patch \
                  file://dss2/0003-OMAP-OMAPFB-add-omapdss-device.patch \
                  file://dss2/0004-OMAP-Add-VRAM-manager.patch \
                  file://dss2/0005-OMAP-Add-support-for-VRFB-rotation-engine.patch \
                  file://dss2/0006-OMAP-DSS2-Documentation-for-DSS2.patch \
                  file://dss2/0007-OMAP-DSS2-Display-Subsystem-Driver-core.patch \
                  file://dss2/0008-OMAP-DSS2-Add-more-core-files.patch \
                  file://dss2/0009-OMAP-DSS2-DISPC.patch \
                  file://dss2/0010-OMAP-DSS2-DPI-driver.patch \
                  file://dss2/0011-OMAP-DSS2-Video-encoder-driver.patch \
                  file://dss2/0012-OMAP-DSS2-RFBI-driver.patch \
                  file://dss2/0013-OMAP-DSS2-SDI-driver.patch \
                  file://dss2/0014-OMAP-DSS2-DSI-driver.patch \
                  file://dss2/0015-OMAP-DSS2-omapfb-driver.patch \
                  file://dss2/0016-OMAP-DSS2-Add-DPI-panel-drivers.patch \
                  file://dss2/0017-OMAP-DSS2-Taal-DSI-command-mode-panel-driver.patch \
                  file://dss2/0001-OMAP3-Enable-DSS2-for-OMAP3EVM-board.patch \
                  file://dss2/0002-V4L2-Added-New-V4L2-CIDs-for-omap-devices-V4L2-IOCT.patch \
                  file://dss2/0003-V4L2-Updated-v4l2_common-for-new-V4L2-CIDs.patch \
                  file://dss2/0004-OMAP2-3-V4L2-Add-support-for-OMAP2-3-V4L2-driver-on.patch \
                  file://expansion-boards/tincantools-zippy.patch \
                  file://madc/madc-driver.patch \
                  file://madc/madc.patch \
                  file://arch-has-holes.diff \
                  file://usb/0001-musb-fix-put_device-call-sequence.patch \
                  file://usb/0008-omap3-Add-CHIP_GE_OMAP3430ES3-for-HSUSB.patch \
                  file://usb/0011-musb-fix-musb-gadget_driver-NULL-bug.patch \
                  file://usb/0012-musb-Add-back-old-musb-procfs-file.patch \
                  file://usb/0013-musb-Remove-USB_SUSPEND-auto-select-with-OTG.patch \
                  file://usb/0014-musb-disable-PING-on-status-phase-of-control-transf.patch \
                  file://usb/0015-musb-Add-context-save-and-restore-support.patch \
                  file://usb/0016-usb-update-defconfig.patch \
                  file://usb/0001-ARM-OMAP-Fix-beagleboard-EHCI-setup.patch \
                  file://modedb-hd720.patch \
                  file://dss2/beagle-dss2-support.patch \
                  file://fix-serial.eml;apply=yes \
                  file://fix-omap4.diff \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

