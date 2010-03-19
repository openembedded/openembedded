require pixman.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "2"
DEFAULT_PREFERENCE_shr = "2"
 
SRC_URI += "\
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch;patch=1 \
           file://0006-Revert-ARM-SIMD-Try-without-any-CFLAGS-before-forcin.patch;patch=1 \ 
           file://over-n-8-0565.patch;patch=1 \
           file://src-8888-0565.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "331415d7a110145cf27aa00e11d0a683"
SRC_URI[archive.sha256sum] = "8cce103af1b4200a13bedca5b763f74c9bc99a55985ab44ca92ba532dac6b57f"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
