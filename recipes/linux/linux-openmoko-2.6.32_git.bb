require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.32.3"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r4"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
# latest stable patch for ubi fix 943e167cb3e8fb191894bde8a4a75db78531a7c8
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
  file://defconfig \
# build fix
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
# patches from Weiss's gdrm-2.6.31 branch
  file://0001-DRM-for-platform-devices.patch;patch=1 \
  file://0002-Glamo-DRM-and-KMS-driver.patch;patch=1 \
  file://0003-Work-on-Glamo-core-for-DRM.patch;patch=1 \
  file://0004-Add-JBT6k74-hook-for-use-by-KMS.patch;patch=1 \
# patches for 2.6.32 gdrm
  file://0001-glamo-drm-use-dev_set_drvdata-instead-of-setting-dri.patch;patch=1 \
  file://0002-glamo-drm-select-DRM_KMS_HELPER-for-crtc-functions.patch;patch=1 \
"

SRC_URI[stablepatch.md5sum] = "6bd3c5fea1e88bb4d0948ec3688bd8f6"
SRC_URI[stablepatch.sha256sum] = "e7526a7ae7210bc7c4f4837e9d8a666f9b126d59bee16015c41c5850d29c841f"

S = "${WORKDIR}/git"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
