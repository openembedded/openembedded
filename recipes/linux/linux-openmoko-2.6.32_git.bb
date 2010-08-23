require linux.inc
require linux-openmoko.inc

KERNEL_RELEASE="2.6.32.20"

SRCREV = "a9254be10ac2294ea20165a87c09ea6afcf66d94"
OEV = "oe3.3"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.32 \
  file://0001-Revert-s3cmci-initialize-default-platform-data-no_wp.patch \
# latest stable patch for ubi fix 943e167cb3e8fb191894bde8a4a75db78531a7c8
  ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;apply=yes;name=stablepatch \
# build fix - only when snd is as module
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch \
# fix runtime issue when built with gcc-4.5
  file://0001-add-noinline-and-noclone-attributes-to-naked-functio.patch \
# patches from Radek Polak used in qtmoko
  file://0002-accels.patch.patch \
  file://0003-usbhost.patch.patch \
  file://0004-ar6000_delay.patch.patch \
  file://0005-save_regs.patch.patch \
# patches from Weiss's gdrm-for-merging branch
  file://0007-DRM-for-platform-devices.patch \
  file://0008-Glamo-DRM-and-KMS-driver.patch \
  file://0009-Work-on-Glamo-core-for-DRM.patch \
  file://0010-JBT6k74-work-for-KMS.patch \
  file://0011-Fix-crash-when-reading-Glamo-registers-via-sysfs.patch \
  file://0012-Fix-dynamic-command-queue-allocation.patch \
  file://0013-Debug-statements-for-testing.patch \
  file://0014-Fix-claim-of-2D-register-resource.patch \
# fix HS Jack
  file://0019-wm8753-use-snd_soc_jack-on-neo1973.patch \
# fix for lost touchscreen https://docs.openmoko.org/trac/ticket/2328
  file://0017-s3c2410_ts-ignore-unexpected-interrupts.patch \
# fix WS
  file://0016-jbt6k74-fix-WS.patch \
  file://0018-glamo-core-initialize-engine-states-as-disabled.patch \
# faster glamo
  file://0020-mfd-glamo-Enable-FIFO-stage-for-the-LCD-engine-s-mem.patch \
  file://0021-glamo-display-fix-WSOD-for-242-timming.patch \
  file://defconfig \
"

SRC_URI[stablepatch.md5sum] = "37cd37164dd7f288dc84f831fc33a598"
SRC_URI[stablepatch.sha256sum] = "d46f29d8e2c3f5f68e074ff6db33ba615486a0994d86f8d03586615e86c0ac52"


S = "${WORKDIR}/git"

do_configure_prepend() {
        install -m 644 ${WORKDIR}/defconfig ${WORKDIR}/defconfig-oe
}
