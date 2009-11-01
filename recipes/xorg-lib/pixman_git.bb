SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.1"
PR = "r3"
PR_append = "+gitr${SRCREV}"

SRCREV = "67bf739187cd43b5fff754b25693f76bb788d1fa"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
file://0002-ARM-Introduction-of-the-new-framework-for-NEON-fast.patch;patch=1 \
file://0003-ARM-Added-pixman_composite_src_8888_0565_asm_neon-f.patch;patch=1 \
file://0004-ARM-Added-pixman_composite_add_8000_8000_asm_neon-f.patch;patch=1 \
file://0005-ARM-Added-pixman_composite_over_8888_8888_asm_neon.patch;patch=1 \
file://0006-ARM-Added-a-set-of-NEON-functions-not-fully-optimi.patch;patch=1 \
file://0007-ARM-Enabled-new-NEON-optimizations.patch;patch=1 \
           file://pixman-28986.patch;patch=1 \
           file://nearest-neighbour.patch;patch=1 \
           file://over-8888-0565.patch;patch=1 \
file://prefetch.patch;patch=1 \
file://neon-24bpp.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

