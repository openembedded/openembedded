require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.32"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
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

S = "${WORKDIR}/git"

do_configure_prepend() { 
	install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
