require ffmpeg.inc

DEPENDS += "schroedinger libgsm"

PE = "1"
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "1"

SRCREV_libswscale = "b2e1c8222eeef74b0ca8053b400957dd69e18e4d"
SRC_URI = "http://ffmpeg.org/releases/ffmpeg-${PV}.tar.bz2 \
	   file://armv4.patch;patch=1 \
       file://ffmpeg-arm-update.diff;patch=1 \
	  "

#S = "${WORKDIR}/git"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF ?= ""

EXTRA_OECONF = " \
        --enable-shared \
        --enable-pthreads \
        --disable-stripping \
        --enable-gpl \
        --enable-nonfree \
        --enable-postproc \
        \
        --cross-prefix=${TARGET_PREFIX} \
        --prefix=${prefix}/ \
        \
        --enable-x11grab \
        --enable-libfaac \
        --enable-libfaad \
        --enable-libfaadbin \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libschroedinger \
        --enable-libtheora  \
        --enable-libvorbis \
        --enable-swscale \
        --arch=${TARGET_ARCH} \
        --enable-cross-compile \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --enable-hardcoded-tables \
        ${EXTRA_FFCONF} \
"

do_configure() {
        sed -i -e s:'check_cflags -std=c99'::g ${S}/configure
        cd ${S}
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
		sed -i -e s:Os:O4:g ${B}/config.h
}

