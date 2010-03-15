DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_acern30 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_acern30 = "\
           http://rtp-net.org/ipaq/patches/2.6.14-3/v2.6.14-gitcurrent.patch;patch=1 \
           http://rtp-net.org/ipaq/patches/2.6.14-3/full.patch;patch=1 \
           file://n30-cleanup.patch;patch=1 \
           file://n35.patch;patch=1 \
           file://n30-lcd.patch;patch=1 \
           file://n30-backlight.patch;patch=1 \
           file://n30-ts.patch;patch=1 \
           file://n30-buttons.patch;patch=1 \
           file://n30-mmc.patch;patch=1 \
           file://n30-mmc-power.patch;patch=1 \
           file://n30-mmc-wprotect.patch;patch=1 \
           file://n30-nand.patch;patch=1 \
           file://n30-usbstart.patch;patch=1 \
           file://n30-hardcode.patch;patch=1 \
           file://n30-apm.patch;patch=1 \
           file://s3c2410fb-resume.patch;patch=1 \
           file://s3c2410_ts-pm.patch;patch=1 \
           file://s3c2410_lcd-pm.c;patch=1 \
           file://s3c2410mci-pm.patch;patch=1 \
           file://s3c2410-nand-pm.patch;patch=1 \
           file://n30-nand-hack.patch;patch=1 \
           file://mmc-plus.patch;patch=1 \
           file://gpio-sysfs.patch;patch=1 \
           file://regdump.patch;patch=1 \
           file://n30-pm.patch;patch=1 \
           file://spi.patch;patch=1 \
           file://wingel-hacking.patch;patch=1 \
           file://gcc4-fixes.patch;patch=1 \
           "

inherit kernel

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
