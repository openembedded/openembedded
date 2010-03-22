SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

PR = "r1"

BBCLASSEXTEND="native"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz;name=archive \
           file://0001-Dropped-delegation-support-for-pixman_blt.patch;patch=1 \
           file://0002-Test-program-for-pixman_blt-function.patch;patch=1 \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
          "
SRC_URI[archive.md5sum] = "32cbdf7a1ac1c275ee56230e26701456"
SRC_URI[archive.sha256sum] = "14ea5a185d8ea6ce3203ff008279e3f3433b6a5bad5853b42a82978527e618cb"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON} --disable-gtk"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

