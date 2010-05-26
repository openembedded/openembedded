require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.31"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "dd32737aa524e09c1d141a0e735dd58674552244"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"
PR = "r6"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-2.6.31 \
# build fix
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch \
# patches from Weiss's gdrm-2.6.31 branch
  file://0001-DRM-for-platform-devices.patch \
  file://0002-Glamo-DRM-and-KMS-driver.patch \
  file://0003-Work-on-Glamo-core-for-DRM.patch \
  file://0004-Add-JBT6k74-hook-for-use-by-KMS.patch \
# enable UBI+DRM+NFS+INOTIFY_USER
  file://0004-gta02_defconfig-Enable-UBI-support.patch \
  file://0005-gta02_defconfig-Enable-UBI-debug.patch \
  file://0001-gta02_defconfig-Enable-GLAMO_DRM.patch \
  file://0006-gta02-defconfig-enable-NFS-and-INOTIFY_USER.patch \
  file://0007-gta02_defconfig-disable-LEDS_GTA02_VIBRATOR.patch \
"

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_defconfig"
CONFIG_NAME_om-gta02 = "gta02_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
