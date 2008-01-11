require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_ts72xx = "1"
DEFAULT_PREFERENCE_mx31moboard = "1"

PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.bz2;patch=1 \
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

SRC_URI_append_mx31moboard = "http://mobots.epfl.ch/mx31moboard/linux-2.6.22-moboard.patch.bz2;patch=1"

S = "${WORKDIR}/linux-2.6.22"
