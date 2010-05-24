require u-boot.inc
PR ="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.sakoman.net/omap3/u-boot.tar.gz \
           file://name.patch \
           file://armv7-a.patch \
           file://500mhz-l2enable.patch \
           file://disable-tone-logo.patch \
           file://env.patch \
          "

S = "${WORKDIR}/u-boot"


