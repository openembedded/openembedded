require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.32.13"

SRCREV = "a9254be10ac2294ea20165a87c09ea6afcf66d94"
OEV = "oe2"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
  file://0001-Revert-s3cmci-initialize-default-platform-data-no_wp.patch;patch=1 \
# latest stable patch for ubi fix 943e167cb3e8fb191894bde8a4a75db78531a7c8
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
# build fix
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
# patches from Radek Polak used in qtmoko
  file://0002-accels.patch.patch;patch=1 \
  file://0003-usbhost.patch.patch;patch=1 \
  file://0004-ar6000_delay.patch.patch;patch=1 \
  file://0005-save_regs.patch.patch;patch=1 \
# defconfig updates
  file://0006-gta02-defconfigs-enable-LEDS_S3C24XX-and-dummy-batte.patch;patch=1 \
# patches from Weiss's gdrm-for-merging branch
  file://0007-DRM-for-platform-devices.patch;patch=1 \
  file://0008-Glamo-DRM-and-KMS-driver.patch;patch=1 \
  file://0009-Work-on-Glamo-core-for-DRM.patch;patch=1 \
  file://0010-JBT6k74-work-for-KMS.patch;patch=1 \
  file://0011-Fix-crash-when-reading-Glamo-registers-via-sysfs.patch;patch=1 \
  file://0012-Fix-dynamic-command-queue-allocation.patch;patch=1 \
  file://0013-Debug-statements-for-testing.patch;patch=1 \
  file://0014-Fix-claim-of-2D-register-resource.patch;patch=1 \
"

SRC_URI[stablepatch.md5sum] = "ba6abb1ffee513a1d4f831599ddae490"
SRC_URI[stablepatch.sha256sum] = "baf6dff5d1c478e65decf2e8b704c60e546ea37c4de59ee8eb6af9dd3d63f145"

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta02 = "gta02_drm_defconfig"

do_configure_prepend() {
        install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
