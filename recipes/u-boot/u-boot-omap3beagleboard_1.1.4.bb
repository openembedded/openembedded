require u-boot.inc
PR ="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.sakoman.net/omap3/u-boot.tar.gz \
           file://name.patch;patch=1 \
           file://armv7-a.patch;patch=1 \
           file://500mhz-l2enable.patch;patch=1 \
           file://disable-tone-logo.patch;patch=1 \
           file://env.patch;patch=1 \
          "

S = "${WORKDIR}/u-boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"

