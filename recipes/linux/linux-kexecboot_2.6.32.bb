require linux-kexecboot.inc

PR = "${INC_PR}.0"

S = "${WORKDIR}/linux-${PV}"
S_omap3 = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omap3 = "1"


SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://v3-1-4-Add-support-for-LZO-compressed-kernels.patch;status=pending \
           file://v3-2-4-Add-support-for-LZO-compressed-kernels-for-ARM.patch;status=pending \
           file://v3-3-4-Add-support-for-LZO-compressed-kernels-on-x86.patch;status=pending \
           file://v3-4-4-Add-LZO-compression-support-for-initramfs-and-old-style-initrd.patch;status=pending \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;status=pending \
           file://defconfig"

SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"

SRC_URI_append_omap3 = " git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git;rev=6833f1a8cdcb65a370f898bde6b6af63f81962df \
file://defconfig \
file://sctp-fix.patch \
file://cm-t35/0001-omap3-cm-t35-add-mux-initialization.patch \
file://cm-t35/0001-OMAP-DSS2-add-Toppoly-TDO35S-panel.patch \
file://cm-t35/0002-omap3-cm-t35-add-DSS2-display-support.patch \
file://cm-t35/0003-omap3-cm-t35-update-defconfig-for-DSS2.patch \
file://cm-t35/0006-omap3-cm-t35-update-defconfig.patch \
file://0001-ARM-OMAP-Overo-Add-support-for-second-ethernet-po.patch \
file://0003-drivers-net-smsc911x-return-ENODEV-if-device-is-n.patch \
file://0004-drivers-input-touchscreen-ads7846-return-ENODEV.patch \
file://0005-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board.patch \
file://0006-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch \
file://0007-ASoC-enable-audio-capture-by-default-for-twl4030.patch \
file://0009-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch \
file://madc/0009-drivers-mfd-add-twl4030-madc-driver.patch \
file://madc/0010-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
file://madc/0011-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch \
file://madc/0013-ARM-OMAP-Add-missing-twl4030-madc-header-file.patch \
file://dss2/0012-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-pane.patch \
#file://dss2/0014-OMAP-DSS-Add-DSS2-support-for-Overo.patch \
file://dss2/0015-OMAP-DSS-Add-DSS2-support-for-Beagle.patch \
file://dss2/0016-video-add-timings-for-hd720.patch \
"
