require linux.inc
require linux-openmoko.inc

KERNEL_RELEASE="2.6.34"

SRCREV = "3f6725d43021d2d7597027e36020df5b44d0667e"
OEV = "oe4.6"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.34 \
# build fix
  file://wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch \
# fix for lost touchscreen https://docs.openmoko.org/trac/ticket/2328
  file://touchscreen_ignoreunexpectedintr34.patch \
# fix runtime issue when built with gcc-4.5
  file://use-noclone-attribute-for-naked.patch \
# patches from Thomas White's gdrm-for-merging branch
  file://0001-DRM-for-platform-devices.patch \
  file://0002-Glamo-DRM-and-KMS-driver.patch \
  file://0003-Work-on-Glamo-core-for-DRM.patch \
  file://0004-JBT6k74-work-for-KMS.patch \
  file://0005-Fix-dynamic-command-queue-allocation.patch \
  file://0006-Debug-statements-for-testing.patch \
  file://0007-Fix-claim-of-2D-register-resource.patch \
  file://0008-Use-unlocked_ioctl-rather-than-ioctl.patch \
  file://0001-glamo-display-Enable-FIFO-stage-for-the-LCD-engine-s.patch \
# patches from Radek Polak used in qtmoko
  file://0001-accels.patch.patch \
  file://0002-usbhost.patch.patch \
  file://0003-ar6000_delay.patch.patch \
  file://0004-save_regs.patch.patch \
# sysfs node path fix
  file://0001-mach-gta02-fix-gsm-power_on-sysfs-node-path.patch \
  file://defconfig \
"

S = "${WORKDIR}/git"

do_configure_prepend() {
        install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
