require pixman.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "2"
 
SRC_URI += "\
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "a4fb870fc325be258089f1683642e976"
SRC_URI[archive.sha256sum] = "b305291bba3d9271a4481e5eedf901025ac8ba4ec8f7b76ccafc5094610cd4ff"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
