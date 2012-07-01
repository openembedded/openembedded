require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "20"

SRC_URI = "git://git.yoctoproject.org/psplash;protocol=git \
          file://logo-math.patch \
          file://psplash-poky-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init \
          file://psplash-18bpp.patch \
          file://psplash-24bpp-BGR666.patch"

S = "${WORKDIR}/git"
