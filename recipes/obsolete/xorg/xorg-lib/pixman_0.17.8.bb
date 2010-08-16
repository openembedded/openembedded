require pixman.inc
PR = "${INC_PR}.0"

SRC_URI += " \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch \
           file://1-composite.patch \
           file://2-composite.patch \
           file://3-composite.patch \
          "
SRC_URI[archive.md5sum] = "a7deb2ff6b286b676d67aa6ae91317ae"
SRC_URI[archive.sha256sum] = "ea24e9003455a0881bd43bf7e4169f2b34c90c8521405103e3490553876a81b4"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "2"
DEFAULT_PREFERENCE_shr = "2"
