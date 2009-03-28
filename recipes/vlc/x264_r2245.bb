DESCRIPTION = "H.264 encoder"
LICENSE = "GPL"
PR = "r1"

X264PV = "snapshot-20090127-2245"

SRC_URI = "http://download.videolan.org/pub/videolan/x264/snapshots/x264-${X264PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${X264PV}"

inherit autotools lib_package

# default --extra-cflags
X264_ECFLAGS = ""

# optimizing --extra-cflags for beagleboard
X264_ECFLAGS_beagleboard = " \
        -s -save-temps -static -Wall -O3 -march=armv7-a \
        -mtune=cortex-a8 -mcpu=cortex-a8 -mfloat-abi=softfp \
        -mfpu=neon -ftree-vectorize -fomit-frame-pointer -ffast-math \
"

# disable use of assembler written functions
X264_DISABLE_ASM = "--disable-asm"
# use assembler written functions for those archs supporting this
#X264_DISABLE_ASM_x86 = ""

EXTRA_OECONF = "--enable-shared ${X264_DISABLE_ASM} --extra-cflags="${X264_ECFLAGS}""

do_stage() {
        autotools_stage_all
}

do_configure() {
        ${S}/configure ${EXTRA_OECONF}
}

