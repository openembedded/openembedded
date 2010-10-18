require pixman.inc
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "532db4194e18c108d0b7dd85f20d39b8"
SRC_URI[archive.sha256sum] = "1484092277c5187f5458229a2b7fd7fbc0cb07e1f220c7f8f9ac65de6dba7989"
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
