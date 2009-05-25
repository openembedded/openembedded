require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "10"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=psplash;proto=http \
          file://psplash-hand-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init"
S = "${WORKDIR}/psplash"

# This really should be default, but due yo openmoko hack below, can't be easily
SRC_URI_append_angstrom = " file://logo-math.patch;patch=1 "
SRC_URI_append_openmoko = " file://configurability.patch;patch=1 "
SRC_URI_append_boc01 = " file://psplash_grayscale.patch;patch=1 "

