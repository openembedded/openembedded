require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.34"

SRCREV = "dd1225cc08c3375bf80289ac1965c724881b149a"
OEV = "oe2"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.34 \
# build fix
  file://wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
# patches from Thomas White's gdrm-for-merging branch
  file://0001-DRM-for-platform-devices.patch;patch=1 \
  file://0002-Glamo-DRM-and-KMS-driver.patch;patch=1 \
  file://0003-Work-on-Glamo-core-for-DRM.patch;patch=1 \
  file://0004-JBT6k74-work-for-KMS.patch;patch=1 \
  file://0005-Fix-crash-when-reading-Glamo-registers-via-sysfs.patch;patch=1 \
  file://0006-Fix-dynamic-command-queue-allocation.patch;patch=1 \
  file://0007-Debug-statements-for-testing.patch;patch=1 \
  file://0008-Fix-claim-of-2D-register-resource.patch;patch=1 \
  file://0009-Use-unlocked_ioctl-rather-than-ioctl.patch;patch=1 \
# patches from Radek Polak used in qtmoko
  file://0001-accels.patch.patch;patch=1 \
  file://0002-usbhost.patch.patch;patch=1 \
  file://0003-ar6000_delay.patch.patch;patch=1 \
  file://0004-save_regs.patch.patch;patch=1 \
"

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta02 = "gta02_drm_defconfig"

do_configure_prepend() {
        install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
