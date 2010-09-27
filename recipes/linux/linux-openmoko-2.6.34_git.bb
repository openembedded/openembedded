require linux.inc
require linux-openmoko.inc

KERNEL_RELEASE="2.6.34.7"

SRCREV = "e4182f3551f1b8e8f8bd07a2d68e49a0ec4cd04a"
OEV = "oe5"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.34 \
# Latest stablepatch
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;apply=yes;name=stablepatch \
# build fix
  file://wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch \
# fix for lost touchscreen https://docs.openmoko.org/trac/ticket/2328
  file://touchscreen_ignoreunexpectedintr34.patch \
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
  file://0009-glamo-display-fix-WSOD-for-242-timming.patch \
# patches from Radek Polak used in qtmoko
  file://0001-accels.patch.patch \
  file://0002-usbhost.patch.patch \
  file://0003-ar6000_delay.patch.patch \
  file://0004-save_regs.patch.patch \
  file://0018-Rename-dev-s3c2410_serialXXX-to-dev-ttySACXXX.patch \
  file://0019-Enable-powering-off-after-8s-POWER-press.patch \
  file://0020-GTA02-bt-remember-state-of-bluetooth-in-variable.patch \
# fix PR2349  
  file://0010-mach-gta02-fix-PR2349-do-not-manage-down.patch \
  file://defconfig \
"

SRC_URI[stablepatch.md5sum] = "a88e4b5a9fcb23c2229301ac4dae1f1a"
SRC_URI[stablepatch.sha256sum] = "b146904ea07cc87a3fbcbd4eab51d331d56718431539e6aa29c24b072e6b7832"

S = "${WORKDIR}/git"

do_configure_prepend() {
        install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
