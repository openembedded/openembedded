PV = "0.4.9-pre1+cvs-${CVSDATE}"
DESCRIPTION = "ffmpeg"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libvorbis faac liba52 lame"
LICENSE = "GPL"
PR = "r1"
S = ${WORKDIR}/ffmpeg
DEFAULT_PREFERENCE = "-1"

inherit autotools

SRC_URI = "cvs://anonymous@mplayerhq.hu/cvsroot/ffmpeg;module=ffmpeg \
	file://configure.patch;patch=0 \
	file://common.patch;patch=1 \
	file://soname.patch;patch=1 \
	"

TARGET_LDFLAGS_append = " -lm -la52 "

EXTRA_OECONF=" \
	--enable-mp3lame \
	--enable-vorbis \
	--enable-faac \
	--enable-a52 \
	--enable-a52bin \
	--enable-pp \
#	--enable-shared-pp \
	--enable-shared \
	--disable-amr_nb \
	--enable-amr_nb-fixed \
	--disable-amr_wb \
	--enable-pthreads \
	--enable-gpl \
	--enable-zlib \
	\
	--disable-audio-beos \
	--disable-v4l \
	--disable-dv1394 \
	--disable-debug \
	--disable-ffserver \
	--disable-ffplay \
	\
	--cross-prefix=${TARGET_PREFIX} \
	--extra-cflags=\$(TARGET_CFLAGS) \
	--extra-ldflags=\$(TARGET_LDFLAGS) \
	--extra-libs=\$(TARGET_LDFLAGS) \
	\
	--cpu=${PACKAGE_ARCH} \
	--prefix=${D}${prefix} \
	--mandir=${D}${prefix}/man \
"

PACKAGES += "libavcodec libavcodec-dev libavformat libavformat-dev"
FILES_${PN} = "${bindir}"
FILES_${PN}-dev = "${includedir}"
FILES_libavcodec = "${libdir}/libavcodec*.so.*"
FILES_libavcodec-dev = "${libdir}/libavcodec*.so ${libdir}/libavcodec*.la ${libdir}/libavcodec*.a"
FILES_libavformat = "${libdir}/libavformat*.so.*"
FILES_libavformat-dev = "${libdir}/libavformat*.so ${libdir}/libavformat*.la ${libdir}/libavformat*.a"

# We do this because the install program is called with -s which causes it to call "strip" and it then mangles cross compiled stuff..
PATH_prepend=${CROSS_DIR}/${TARGET_SYS}/bin:


do_configure_prepend() {
	export CC="${CC}"
}

do_stage() {
	oe_libinstall -a -so -C libavcodec libavcodec ${STAGING_LIBDIR}
	oe_libinstall -a -so -C libavformat libavformat ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/ffmpeg
	install -m 0644 ${S}/libavcodec/avcodec.h ${STAGING_INCDIR}/ffmpeg/avcodec.h
	install -m 0644 ${S}/libavcodec/common.h ${STAGING_INCDIR}/ffmpeg/common.h
	install -m 0644 ${S}/libavcodec/rational.h ${STAGING_INCDIR}/ffmpeg/rational.h
	install -m 0644 ${S}/libavformat/avformat.h ${STAGING_INCDIR}/ffmpeg/avformat.h
	install -m 0644 ${S}/libavformat/avio.h ${STAGING_INCDIR}/ffmpeg/avio.h
	install -m 0644 ${S}/libavformat/rtp.h ${STAGING_INCDIR}/ffmpeg/rtp.h
	install -m 0644 ${S}/libavformat/rtsp.h ${STAGING_INCDIR}/ffmpeg/rtsp.h
	install -m 0644 ${S}/libavformat/rtspcodes.h ${STAGING_INCDIR}/ffmpeg/rtspcodes.h
}
