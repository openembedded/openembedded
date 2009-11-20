SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.1"
PR = "r4"
PR_append = "+gitr${SRCREV}"

SRCREV = "abefe68ae2a422fecf315f17430c0cda5561be66"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
           file://nearest-neighbour.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

