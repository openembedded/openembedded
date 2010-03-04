SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.8"
PR = "r6"
PR_append = "+gitr${SRCREV}"

BBCLASSEXTEND="native"

SRCREV = "7a15fa25ddb88ebb4ac00772854271f102f06e81"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://anongit.freedesktop.org/~sandmann/pixman;protocol=git;branch=flags \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://1-composite.patch;patch=1 \
           file://2-composite.patch;patch=1 \
           file://3-composite.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON} --disable-gtk"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

