require pixman.inc

SRC_URI[archive.md5sum] = "100a2d23f1d5683fdaa5d7ca71a0182b"
SRC_URI[archive.sha256sum] = "04e613f87fec13e5d6e8540587af1112e9ab19f9d550751e848a2d65deb26fd6"

PR = "${INC_PR}.1"

SRC_URI += "\
           file://0001-ARM-HACK-added-NEON-optimizations-for-fetch-store-r5.patch \
           file://0002-Don-t-discriminate-PAD-and-REFLECT-repeat-in-standar.patch \
           file://0003-Generic-C-implementation-of-pixman_blt-with-overlapp.patch \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch \
           file://0005-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch \
           file://0006-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch \
           file://0007-ARM-added-neon_composite_add_0565_8_0565-fast-path.patch \
           file://0008-ARM-added-neon_composite_out_reverse_0565_8_0565-fas.patch \
           file://0009-ARM-added-neon_composite_out_reverse_8_0565-fast-pat.patch \
"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "2"
DEFAULT_PREFERENCE_shr = "2"
