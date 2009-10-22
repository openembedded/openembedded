require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"
KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "2.6.29-rc3-drm"

OMV = "oe13"
PV = "${KERNEL_RELEASE}-KMS-${OMV}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=drm-tracking \
  file://fix-install.patch;patch=1 \
  file://fix-missing-semicolon.patch;patch=1 \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_drm_defconfig"
CONFIG_NAME_om-gta03 = "gta03_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
