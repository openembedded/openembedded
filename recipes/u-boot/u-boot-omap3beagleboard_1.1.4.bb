require u-boot.inc
PR ="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.sakoman.net/omap3/u-boot.tar.gz \
           file://name.patch;apply=yes \
           file://armv7-a.patch;apply=yes \
           file://500mhz-l2enable.patch;apply=yes \
           file://disable-tone-logo.patch;apply=yes \
           file://env.patch;apply=yes \
          "

S = "${WORKDIR}/u-boot"


