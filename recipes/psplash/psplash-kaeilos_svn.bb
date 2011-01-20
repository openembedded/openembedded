require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "20"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=psplash;proto=http \
          file://logo-math.patch \
          file://psplash-poky-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init \
          file://psplash-18bpp.patch \
          file://psplash-24bpp-BGR666.patch"

S = "${WORKDIR}/psplash"


