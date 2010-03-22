require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"
KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "2.6.29-rc3-drm"

SRCREV = "e62a4ae1c6783f41b41a9ac3d258786586b65a40"
OMV = "oe15"
PV = "${KERNEL_RELEASE}-drm-${OMV}+gitr${SRCREV}"
PR = "r5"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=drm-tracking \
  file://fix-install.patch;patch=1 \
  file://0001-Add-drm-to-Makefile-version.patch;patch=1 \
  file://0004-gta02_drm_defconfig-start-from-gta02_packaging_defco.patch;patch=1 \
  file://0005-Enable-DRM-and-MFD_GLAMO_DRM.patch;patch=1 \
  file://0006-Enable-I2C_ALGOBIT-from-make-oldconfig.patch;patch=1 \
  file://0007-Enable-UBI-UBIFS.patch;patch=1 \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_drm_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
