require pixman.inc
PR = "${INC_PR}.3"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "2"
 
SRC_URI += "\
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;apply=yes \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;apply=yes \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;apply=yes \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;apply=yes \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch;apply=yes \
           file://calloc.patch;apply=yes \
           file://tls.patch;apply=yes \
           file://565-scanline.patch;apply=yes \
           file://missing-cache-preload.diff;apply=yes \
"

SRC_URI[archive.md5sum] = "a4fb870fc325be258089f1683642e976"
SRC_URI[archive.sha256sum] = "b305291bba3d9271a4481e5eedf901025ac8ba4ec8f7b76ccafc5094610cd4ff"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
