require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.28"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r4"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  file://openwrt-ledtrig-netdev.patch;patch=1 \
  file://0001-MERGE-via-pending-tracking-hist-subject-usb-gadget-r.patch;patch=1 \
  file://0002-MERGE-via-pending-tracking-hist-subject-usb-gadget-f.patch;patch=1 \
  file://0003-consider-alrm-enable-in-pcf50633_rtc_set_alarm.patch;patch=1 \
  file://0004-manage-RTC-alarm-pending-flag-of-PCF50633.patch;patch=1 \
  file://0005-debug-glamo-allow-slower-memory-bus.patch.patch;patch=1 \
  file://0006-Subject-fix_glamo_xrandr_bug.patch.patch;patch=1 \
  file://0007-Subject-glamo_fix_improper_xrandr_geometry_setting.patch;patch=1 \
  file://0008-Send-pen-up-events-faster-side-effect-improve-illu.patch;patch=1 \
  file://defconfig-oe.patch \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01-moredrivers-defconfig"
CONFIG_NAME_om-gta02 = "gta02-packaging-defconfig"
CONFIG_NAME_om-gta03 = "gta03_defconfig"

do_configure_prepend() {
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
	cat ${WORKDIR}/defconfig-oe.patch | patch -p0 -d ${WORKDIR}
}

