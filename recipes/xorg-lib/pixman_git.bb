require pixman.inc
PV = "0.17.13"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCREV}"

SRCREV = "69f1ec9a7827aeb522fcae99846237ef0f896e7b"
 
DEFAULT_PREFERENCE = "-1"
 
SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git;branch=master \
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch;patch=1 \
           file://0006-Revert-ARM-SIMD-Try-without-any-CFLAGS-before-forcin.patch;patch=1 \ 
           file://over-n-8-0565.patch;patch=1 \
           file://src-8888-0565.patch;patch=1 \
"

S = "${WORKDIR}/git"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
