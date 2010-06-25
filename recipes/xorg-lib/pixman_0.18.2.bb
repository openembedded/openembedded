require pixman.inc
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "5d1378fa61610dd5d3c7e0111b2c5253"
SRC_URI[archive.sha256sum] = "80aee833b429d105d2c7593ef96993da04441b3b747084f1f3bfd7be594e1c45"
SRC_URI += "\
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch\
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch\
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch\
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch\
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch\
           file://0006-A-copy-paste-version-of-16bpp-bilinear-scanline-fetc.patch\
           file://0007-ARM-added-missing-cache-preload.patch\
           file://565-over-neon.patch \
           file://neon-reverse-u.patch \
"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "2"
DEFAULT_PREFERENCE_shr = "2"
