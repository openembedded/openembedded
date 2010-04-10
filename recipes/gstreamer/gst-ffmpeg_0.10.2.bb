DESCRIPTION = "FFmpeg-based GStreamer plug-in"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer gst-plugins-base zlib"
PR = "r2"

inherit autotools pkgconfig

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2 \
	   file://armv5.patch;patch=1 \
	   file://autotools.patch;patch=1 \
          "

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"

EXTRA_OECONF = "--disable-sdltest --disable-ffplay --disable-freetypetest \
		--disable-vorbis --disable-vorbistest --disable-encoders \
		--disable-v4l --disable-audio-oss --disable-dv1394 \
		--disable-vhook --disable-ffmpeg --disable-ffserver \
		--enable-pp --disable-decoder-vorbis"

# We do this because the install program is called with -s which causes it to
# call "strip" and it then mangles cross compiled stuff..
PATH_prepend="${CROSS_DIR}/${TARGET_SYS}/bin:"

# Hack to get STAGING_LIBDIR into the linker path when building ffmpeg
CC = "${CCACHE} ${HOST_PREFIX}gcc ${TARGET_CC_ARCH} -L${STAGING_LIBDIR}"


SRC_URI[md5sum] = "3c7fb1cd1308b1972a76b86bb29fc890"
SRC_URI[sha256sum] = "ffa7c89bccab5d1be53b6fcedcf7a5c071d585cf522fee5864add05d350f5842"
