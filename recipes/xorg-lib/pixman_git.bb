SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.17.10"
PR = "r0"
PR_append = "+gitr${SRCREV}"

BBCLASSEXTEND="native"

SRCREV = "313353f1fb9d40d0c3aaf7cfb99ca978b29003a4"
 
DEFAULT_PREFERENCE = "-1"
 
SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git;branch=master \
           file://0001-Add-CONVERT_0565_TO_8888-macro.patch;patch=1 \
           file://0002-Add-CONVERT_8888_TO_8888-and-CONVERT_0565_TO_0565-ma.patch;patch=1 \
           file://0003-Add-FAST_PATH_NO_NONE_REPEAT-flag.patch;patch=1 \
           file://0004-Add-FAST_PATH_SAMPLES_COVER_CLIP-and-FAST_PATH_16BIT.patch;patch=1 \
           file://0005-Add-specialized-fast-nearest-scalers.patch;patch=1 \
           file://0006-Generic-C-implementation-of-pixman_blt-with-overlapp.patch;patch=1 \
           file://0007-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch;patch=1 \
           file://0008-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch;patch=1 \
           file://0009-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch;patch=1 \
           file://over-n-8-0565.patch;patch=1 \
           file://src-8888-0565.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

