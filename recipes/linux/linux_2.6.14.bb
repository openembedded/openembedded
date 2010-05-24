DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_acern30 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig"

SRC_URI_append_acern30 = "\
           http://rtp-net.org/ipaq/patches/2.6.14-3/v2.6.14-gitcurrent.patch;apply=yes;name=patch1 \
           http://rtp-net.org/ipaq/patches/2.6.14-3/full.patch;apply=yes;name=patch2 \
           file://n30-cleanup.patch;apply=yes \
           file://n35.patch;apply=yes \
           file://n30-lcd.patch;apply=yes \
           file://n30-backlight.patch;apply=yes \
           file://n30-ts.patch;apply=yes \
           file://n30-buttons.patch;apply=yes \
           file://n30-mmc.patch;apply=yes \
           file://n30-mmc-power.patch;apply=yes \
           file://n30-mmc-wprotect.patch;apply=yes \
           file://n30-nand.patch;apply=yes \
           file://n30-usbstart.patch;apply=yes \
           file://n30-hardcode.patch;apply=yes \
           file://n30-apm.patch;apply=yes \
           file://s3c2410fb-resume.patch;apply=yes \
           file://s3c2410_ts-pm.patch;apply=yes \
           file://s3c2410_lcd-pm.c;apply=yes \
           file://s3c2410mci-pm.patch;apply=yes \
           file://s3c2410-nand-pm.patch;apply=yes \
           file://n30-nand-hack.patch;apply=yes \
           file://mmc-plus.patch;apply=yes \
           file://gpio-sysfs.patch;apply=yes \
           file://regdump.patch;apply=yes \
           file://n30-pm.patch;apply=yes \
           file://spi.patch;apply=yes \
           file://wingel-hacking.patch;apply=yes \
           file://gcc4-fixes.patch;apply=yes \
           "

inherit kernel

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

SRC_URI[kernel.md5sum] = "66d02cbd723876c6d69846a067875a22"
SRC_URI[kernel.sha256sum] = "cc56285834bed461fd405c00a34d3c3095673333b94621580eeeb0c65237af15"

SRC_URI[patch1.md5sum] = "e0b42e51630e9cd7e3b0adf1be42f4a1"
SRC_URI[patch1.sha256sum] = "0c625e90d13f91269d3a02ebdfba97226651a849ad8d69a0734bb5df7964c571"
SRC_URI[patch2.md5sum] = "d7ec27a9b44eed194426038640af5460"
SRC_URI[patch2.sha256sum] = "70e8e8230390fb355d62270764f18f6b553bcb9383ddabfbed4a1238b0e79b80"
