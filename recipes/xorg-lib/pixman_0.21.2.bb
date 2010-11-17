require pixman.inc

SRC_URI[archive.md5sum] = "9e09fd6e58cbf9717140891e0b7d4a7a"
SRC_URI[archive.sha256sum] = "295f51416caf307ff7caf1153ee9b1d86b9f7f02a7876d12db6538d80451c5de"

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
"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
