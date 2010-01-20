SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"

BBCLASSEXTEND="native"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz \
           file://0001-Dropped-delegation-support-for-pixman_blt.patch;patch=1 \
           file://0002-Test-program-for-pixman_blt-function.patch;patch=1 \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
          "

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

