SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.3"
PR = "r6"
PR_append = "+gitr${SRCREV}"

BBCLASSEXTEND="native"

SRCREV = "c97b1e803fc214e9880eaeff98410c8fa37f9ddc"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
           file://nearest-neighbour.patch;patch=1 \
           file://0001-ARM-NEON-optimized-pixman_blt.patch;patch=1 \
           file://0002-Test-program-for-pixman_blt-function.patch;patch=1 \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON} --disable-gtk"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

