require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.32.10"

SRCREV = "14be1091928fcce66812a85129768fb253b36420"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r5"

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
  file://0010-Simplify-the-JBT6k74-driver.patch;patch=1 \
  file://0011-Don-t-choke-if-userspace-provides-a-pixel-clock-valu.patch;patch=1 \
  file://0012-Report-all-FB-modes-given-by-the-lower-levels.patch;patch=1 \
  file://0013-Change-connector-type-to-LVDS.patch;patch=1 \
  file://0014-Clean-up-JBT-hooks-and-allow-resolution-switching.patch;patch=1 \
  file://0015-ar6000-send-userspace-an-event-on-disconnection.patch;patch=1 \
  file://0016-Enable-display-before-trying-to-set-mode-or-base.patch;patch=1 \
"

SRC_URI[stablepatch.md5sum] = "0f1863836bf96fd0aab128d61eaa5693"
SRC_URI[stablepatch.sha256sum] = "e4b760254822dbc77ae1889d0b2078c113cb7939f8c6ee31c49a31b07b52cc18"


S = "${WORKDIR}/git"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
