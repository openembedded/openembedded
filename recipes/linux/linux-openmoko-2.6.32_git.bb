require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.32.13"

SRCREV = "a9254be10ac2294ea20165a87c09ea6afcf66d94"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
  file://0001-Revert-s3cmci-initialize-default-platform-data-no_wp.patch;patch=1 \
# latest stable patch for ubi fix 943e167cb3e8fb191894bde8a4a75db78531a7c8
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
# build fix
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
# patches from Weiss's gdrm-2.6.32 branch
  file://0002-DRM-for-platform-devices.patch;patch=1 \
  file://0003-Glamo-DRM-and-KMS-driver.patch;patch=1 \
  file://0004-Work-on-Glamo-core-for-DRM.patch;patch=1 \
  file://0005-Add-JBT6k74-hook-for-use-by-KMS.patch;patch=1 \
  file://0006-glamo-drm-use-dev_set_drvdata-instead-of-setting-dri.patch;patch=1 \
  file://0007-glamo-drm-select-DRM_KMS_HELPER-for-crtc-functions.patch;patch=1 \
  file://0008-Fix-crash-when-reading-Glamo-registers-via-sysfs.patch;patch=1 \
  file://0009-A-couple-of-GEM-refcounting-fixes.patch;patch=1 \
  file://0010-Simplify-the-JBT6k74-driver.patch;patch=1 \
  file://0011-Don-t-choke-if-userspace-provides-a-pixel-clock-valu.patch;patch=1 \
  file://0012-Report-all-FB-modes-given-by-the-lower-levels.patch;patch=1 \
  file://0013-Change-connector-type-to-LVDS.patch;patch=1 \
  file://0014-Clean-up-JBT-hooks-and-allow-resolution-switching.patch;patch=1 \
  file://0015-Enable-display-before-trying-to-set-mode-or-base.patch;patch=1 \
  file://0016-accels.patch.patch;patch=1 \
  file://0017-usbhost.patch.patch;patch=1 \
  file://0018-ar6000_delay.patch.patch;patch=1 \
  file://0019-save_regs.patch.patch;patch=1 \
  file://0020-Fix-KMS-framebuffer-physical-address.patch;patch=1 \
  file://0021-Reject-modes-with-clock-0.patch;patch=1 \
  file://0022-JBT6k74-tweaks-Make-resolution-switch-work.patch;patch=1 \
  file://0023-Remove-a-couple-of-debugging-messages.patch;patch=1 \
  file://0024-Enable-dummy-frames-when-switching-resolution.patch;patch=1 \
  file://0025-Almost-make-rotation-work.patch;patch=1 \
  file://0026-gta02-defconfigs-enable-LEDS_S3C24XX.patch;patch=1 \
"

SRC_URI[stablepatch.md5sum] = "ba6abb1ffee513a1d4f831599ddae490"
SRC_URI[stablepatch.sha256sum] = "baf6dff5d1c478e65decf2e8b704c60e546ea37c4de59ee8eb6af9dd3d63f145"

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta02 = "gta02_drm_defconfig"

do_configure_prepend() {
        install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
