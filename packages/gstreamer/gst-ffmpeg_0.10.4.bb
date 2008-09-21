DESCRIPTION = "FFmpeg-based GStreamer plug-in"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "ffmpeg gstreamer gst-plugins-base zlib"
PR = "r7"

inherit autotools pkgconfig

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2 \
           file://configure-hack.diff;patch=1 \
"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"

EXTRA_OECONF = "--disable-sdltest --disable-ffplay --disable-freetypetest \
		--disable-vorbis --disable-vorbistest --disable-encoders \
		--disable-v4l --disable-audio-oss --disable-dv1394 \
		--disable-vhook --with-system-ffmpeg --disable-ffserver \
		--enable-pp --disable-decoder-vorbis"

# We do this because the install program is called with -s which causes it to
# call "strip" and it then mangles cross compiled stuff..
PATH_prepend="${CROSS_DIR}/${TARGET_SYS}/bin:"

# Hack to get STAGING_LIBDIR into the linker path when building ffmpeg
CC = "${CCACHE} ${HOST_PREFIX}gcc ${TARGET_CC_ARCH} -L${STAGING_LIBDIR}"

