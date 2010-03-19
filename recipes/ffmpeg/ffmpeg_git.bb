require ffmpeg.inc

DEPENDS += "schroedinger libgsm"

PE = "1"
PV = "0.5.0+${PR}+gitr${SRCREV}" 
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

#FFBRANCH_arm = "arm"
FFBRANCH ?= "master"

# When bumping SRCREV make sure you bump PR here and in dependant recipes (gst-ffmpeg, gnash, omxil, etc) to account for SOVERSION changes
SRCREV = "d886804643d7427debfa70d824de7e53ae8e3e83"
SRCREV_arm = "d886804643d7427debfa70d824de7e53ae8e3e83"
SRCREV_libswscale = "b2e1c8222eeef74b0ca8053b400957dd69e18e4d"
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
        --enable-libschroedinger \
        --enable-libtheora  \
        --enable-libvorbis \
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
	git clone git://git.mplayerhq.hu/libswscale || true
	cd libswscale
	git checkout ${SRCREV_libswscale} || true
	cd ${S}
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
		sed -i -e s:Os:O4:g ${B}/config.h
}

