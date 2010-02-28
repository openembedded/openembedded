SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PR = "r1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "2"
DEFAULT_PREFERENCE_shr = "2"

BBCLASSEXTEND="native"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz;name=archive \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://1-composite.patch;patch=1 \
           file://2-composite.patch;patch=1 \          
           file://3-composite.patch;patch=1 \          
          "

SRC_URI[archive.md5sum] = "a7deb2ff6b286b676d67aa6ae91317ae"
SRC_URI[archive.sha256sum] = "ea24e9003455a0881bd43bf7e4169f2b34c90c8521405103e3490553876a81b4"

inherit autotools

NEON = " --disable-arm-neon "
NEON_armv7a = ""

EXTRA_OECONF = "${NEON} --disable-gtk"

