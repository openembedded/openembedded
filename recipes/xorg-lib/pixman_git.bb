SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.1"
PR = "r2"
PR_append = "+gitr${SRCREV}"

SRCREV = "7af985a69a9147e54dd5946a8062dbc2e534b735"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
           file://pixman-28986.patch;patch=1 \
           file://nearest-neighbour.patch;patch=1 \
           file://remove-broken.patch;patch=1 \
           file://over-8888-0565.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

