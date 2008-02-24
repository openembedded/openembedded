DESCRIPTION = "ffmpeg"
HOMEPAGE = "http://ffmpeg.mplayerhq.hu/"
AUTHOR = "Fabrice Bellard ffmpeg-devel@mplayerhq.hu"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "zlib libvorbis faac liba52 lame"
RSUGGESTS = "mplayer"

inherit autotools pkgconfig

TARGET_LDFLAGS_append = " -lm -la52 "

EXTRA_OECONF = "\
        --enable-pp \
        --enable-shared \
        --enable-pthreads \
        --enable-gpl \
        \
        --disable-audio-beos \
        --disable-v4l \
        --disable-dv1394 \
        --disable-debug \
        --disable-ffserver \
        --disable-ffplay \
        \
        --cross-prefix=${TARGET_PREFIX} \
        \
        --cpu=${PACKAGE_ARCH} \
        \
"

# We do this because the install program is called with -s which causes it to call "strip" and it then mangles cross compiled stuff..
PATH_prepend="${CROSS_DIR}/${TARGET_SYS}/bin:"

do_configure_prepend() {
        export CC="${CC}"
}
