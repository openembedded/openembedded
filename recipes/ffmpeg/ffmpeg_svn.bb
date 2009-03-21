require ffmpeg.inc

DEPENDS += "schroedinger libgsm"

SRCREV = "16396"

PE = "1"
PV = "0.4.9+svnr${SRCREV}"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.ffmpeg.org/ffmpeg/;module=trunk"

S = "${WORKDIR}/trunk"

DEFAULT_PREFERENCE = "-1"

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
        --prefix=${prefix} \
        \
        --enable-x11grab \
        --enable-libfaac \
        --enable-libfaad \
        --enable-libfaadbin \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libschroedinger \
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
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
		sed -i -e s:Os:O4:g ${B}/config.h
}

