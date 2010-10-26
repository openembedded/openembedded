require pixman.inc

SRC_URI[archive.md5sum] = "3f31cf670880199979d71a3234308cc9"
SRC_URI[archive.sha256sum] = "1bc9f0b00de69e3aeab3525012506608ea3d913eb452d0134c729c1d7abab1b5"

PR = "${INC_PR}.0"

SRC_URI += "\
           file://0000-Add-pixman_bits_override_accessors.patch \
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch \
           file://0006-ARM-added-NEON-optimizations-for-fetch-store-a8-scan.patch \
           file://0007-ARM-added-NEON-optimizations-for-fetching-x8r8g8b8-s.patch \
           file://0008-ARM-optimization-for-scaled-src_0565_0565-operation-.patch \
"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
