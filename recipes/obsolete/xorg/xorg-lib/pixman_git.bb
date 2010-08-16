require pixman.inc
PV = "0.17.13"
PR = "${INC_PR}.2"
PR_append = "+gitr${SRCPV}"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git;branch=master \
           file://0001-Generic-C-implementation-of-pixman_blt-with-overlapp.patch \
           file://0002-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch \
           file://0003-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch \
           file://0004-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch \
           file://0005-ARM-added-NEON-optimizations-for-fetch-store-r5g6b5-.patch \
           file://0006-Revert-ARM-SIMD-Try-without-any-CFLAGS-before-forcin.patch \
           file://over-n-8-0565.patch \
           file://src-8888-0565.patch \
           file://calloc.patch \
           file://tls.patch \
"

SRCREV = "69f1ec9a7827aeb522fcae99846237ef0f896e7b"
S = "${WORKDIR}/git"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

DEFAULT_PREFERENCE = "-1"
