require ffmpeg.inc

DEPENDS += "virtual/libsdl schroedinger libgsm libvpx"

# When bumping SRCREV make sure you bump PR here and in dependant recipes (gst-ffmpeg, gnash, omxil, etc) to account for SOVERSION changes
SRCREV = "0b32da90f893b3e04ead18a546252e241a6a0988"

PV = "0.6.1+${PR}+gitr${SRCPV}"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"

SRC_URI = "git://git.libav.org/libav.git;protocol=git"

S = "${WORKDIR}/git"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -fno-tree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF ?= ""

EXTRA_OECONF = " \
        --enable-shared \
        --enable-pthreads \
        --disable-stripping \
        --enable-gpl \
        --enable-postproc \
        \
        --cross-prefix=${TARGET_PREFIX} \
        --prefix=${prefix} \
        \
        --enable-ffserver \
        --enable-ffplay \
        --enable-x11grab \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libschroedinger \
        --enable-libtheora  \
        --enable-libvorbis \
        --enable-libvpx \
        --arch=${TARGET_ARCH} \
        --target-os="linux" \
        --enable-cross-compile \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --sysroot="${STAGING_DIR_TARGET}" \
        --enable-hardcoded-tables \
        ${EXTRA_FFCONF} \
"

do_configure() {
#        sed -i -e s:'check_cflags -std=c99'::g ${S}/configure
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
        sed -i -e s:Os:O4:g ${B}/config.h
}

