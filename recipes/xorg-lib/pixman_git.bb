SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.15.16"
PR = "r1"
PR_append = "+gitr${SRCREV}"

SRCREV = "f9660ce29ed072c6cbaec711c5d18b9f0ba113ae"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

