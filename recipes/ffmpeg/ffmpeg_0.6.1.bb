require ffmpeg.inc

LICENSE = "LGPLv2.1+"
DEPENDS += "schroedinger libgsm"
PR = "${INC_PR}.1"

SRC_URI = "http://ffmpeg.org/releases/ffmpeg-${PV}.tar.bz2"
SRC_URI[md5sum] = "4f5d732d25eedfb072251b5314ba2093"
SRC_URI[sha256sum] = "e348aa6d0bb199f231aa3a48e8f457f037c763219bccc8b395e007ccd87ebd5f"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF_mipsel = "--arch=mips"

EXTRA_OECONF = " \
        --arch=${TARGET_ARCH} \
        --cross-prefix=${TARGET_PREFIX} \
        --disable-stripping \
        --enable-cross-compile \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libschroedinger \
        --enable-libtheora  \
        --enable-libvorbis \
        --enable-pthreads \
        --enable-shared \
        --enable-swscale \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --sysroot="${STAGING_DIR_TARGET}" \
        --prefix=${prefix}/ \
        --target-os=linux \
        ${EXTRA_FFCONF} \
"

do_configure() {
        ./configure ${EXTRA_OECONF}
}

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"
