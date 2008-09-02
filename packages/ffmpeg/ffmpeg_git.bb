require ffmpeg.inc

DEPENDS += "libgsm"

PV = "0.4.9+${PR}+gitr${SRCREV}" 
PR = "r29"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_armv5te = "1"
DEFAULT_PREFERENCE_armv6 = "1"
DEFAULT_PREFERENCE_armv7a = "1"

FFBRANCH_arm = "arm"
FFBRANCH ?= "master"

# When bumping SRCREV make sure you bump PR here and in dependant recipes (gst-ffmpeg, gnash, omxil, etc) to account for SOVERSION changes
SRCREV = "3692b8de9fae73860be636606cb6344f26e28b1a"
SRCREV_arm = "2a56b3705935a53fb48d605340095fb462d6acc5"
SRC_URI = "git://git.mansr.com/ffmpeg.mru;protocol=git;branch=${FFBRANCH} \
"

S = "${WORKDIR}/git"
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
        cd ${S} ; git clone git://git.mplayerhq.hu/libswscale || true  
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
		sed -i -e s:Os:O4:g ${B}/config.h
}

