require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_ts72xx = "-1"

PR = "r1"

BASE_KERNEL_VERSION = "2.6.22"
KERNEL_VERSION = "2.6.23-rc5"
KERNEL_RELEASE = "2.6.23-rc5"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${BASE_KERNEL_VERSION}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.23/patch-${KERNEL_VERSION}.bz2;patch=1;name=patch \
           file://defconfig \
           "

SRC_URI_append_ts72xx = "\
           file://ep93xx-gpio-interrupt-debounce.diff;patch=1 \
           file://ep93xx-i2c-bus.diff;patch=1 \
           file://ep93xx-i2c.diff;patch=1 \
           file://ep93xx-leds.diff;patch=1 \
           file://ep93xx-serial-uartbaud.diff;patch=1 \
           file://ep93xx-serial-clocks.diff;patch=1 \
           file://ep93xx-timer-accuracy.diff;patch=1 \
           file://ep93xx-maverick-uniqid.patch;patch=1 \
           file://ts72xx-nfbit-fix.patch;patch=1 \
           file://ts72xx-machine-id-fix.patch;patch=1 \
           file://ts72xx-watchdog.patch;patch=1 \
           file://ts72xx-use-cpld-reset.patch;patch=1 \
           "

S = "${WORKDIR}/linux-2.6.22"

SRC_URI[kernel.md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[kernel.sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
SRC_URI[patch.md5sum] = "8253467313749aee6065093cd3c5fd9c"
SRC_URI[patch.sha256sum] = "c8c2068183aca79c46182f3d3fe6d7579cd60809681d42c52d71cf1873cd1a0e"
