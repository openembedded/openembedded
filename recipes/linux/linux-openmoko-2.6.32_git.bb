require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.32.8"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
# latest stable patch for ubi fix 943e167cb3e8fb191894bde8a4a75db78531a7c8
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
  file://defconfig \
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
"

SRC_URI[stablepatch.md5sum] = "eabf01da4c72f7ea5b4e4bf8e8535e5f"
SRC_URI[stablepatch.sha256sum] = "50c08a7ffcad1e7cd2e7c2c906795896dd36ce71249d816914c306dcc5875fd2"

S = "${WORKDIR}/git"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
