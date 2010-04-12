DESCRIPTION = "FFmpeg-based GStreamer plug-in"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "ffmpeg gstreamer gst-plugins-base zlib"

inherit autotools pkgconfig

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${PV}.tar.bz2 \
           file://lower-rank.diff;patch=1 \
"

PR = "r2"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"

EXTRA_OECONF = " --with-system-ffmpeg "

# We do this because the install program is called with -s which causes it to
# call "strip" and it then mangles cross compiled stuff..
PATH_prepend="${CROSS_DIR}/${TARGET_SYS}/bin:"

# Hack to get STAGING_LIBDIR into the linker path when building ffmpeg
CC = "${CCACHE} ${HOST_PREFIX}gcc ${TARGET_CC_ARCH} -L${STAGING_LIBDIR}"


SRC_URI[md5sum] = "a7177f85c87d404a3c0d511b835129d1"
SRC_URI[sha256sum] = "d9e056793d05bf0b6f4989b27d3107c2f223a14205ee54be403bbe52945c8853"
