require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "10"

SRC_URI = "git://git.yoctoproject.org/psplash;protocol=git \
          file://psplash-poky-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init"
S = "${WORKDIR}/git"

# This really should be default, but due yo openmoko hack below, can't be easily
SRC_URI_append_angstrom = " file://logo-math.patch "
SRC_URI_append_jlime = " file://configurability.patch file://progress-color.patch "
SRC_URI_append_openmoko = " file://configurability.patch "
SRC_URI_append_boc01 = " file://psplash_grayscale.patch "
