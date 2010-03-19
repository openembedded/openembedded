SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.11"
PR = "r2"
PR_append = "+gitr${SRCREV}"

BBCLASSEXTEND="native"

SRCREV = "265ea1fb4d05a920323f23a02f9dc379312bbdae"
 
DEFAULT_PREFERENCE = "-1"
 
SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git;branch=master \
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://over-n-8-0565.patch;patch=1 \
           file://src-8888-0565.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

