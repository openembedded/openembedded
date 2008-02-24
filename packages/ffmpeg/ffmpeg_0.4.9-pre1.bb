require ffmpeg.inc

PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/ffmpeg/ffmpeg-${PV}.tar.gz \
           file://configure.patch;patch=0 \
           file://gcc4.patch;patch=1 \
           file://soname.patch;patch=1 \
          "

EXTRA_OECONF += " \
        \
        --prefix=${D}${prefix} \
        --mandir=${D}${prefix}/share/man \
        \
        --enable-mp3lame \
        --enable-vorbis \
        --enable-faad \
        --enable-faadbin \
        --enable-faac \
        --enable-a52 \
        --enable-a52bin \
        --enable-shared-pp \
        --disable-amr_nb \
        --enable-amr_nb-fixed \
        --disable-amr_wb \
        \
        --cpu=${TARGET_ARCH} \
        --tune=${PACKAGE_ARCH} \
        --extra-ldflags="-la52" \
        \
        --disable-audio-beos \
        --disable-v4l \
        --disable-dv1394 \
"

do_stage() {
        oe_libinstall -a -so -C libavcodec  libavcodec ${STAGING_LIBDIR}
        oe_libinstall -a -so -C libavformat libavformat ${STAGING_LIBDIR}

        install -d ${STAGING_INCDIR}/ffmpeg

        install -m 0644 ${S}/libavcodec/avcodec.h  ${STAGING_INCDIR}/ffmpeg/avcodec.h
        install -m 0644 ${S}/libavcodec/common.h   ${STAGING_INCDIR}/ffmpeg/common.h
        install -m 0644 ${S}/libavcodec/rational.h ${STAGING_INCDIR}/ffmpeg/rational.h

        install -m 0644 ${S}/libavformat/avformat.h  ${STAGING_INCDIR}/ffmpeg/avformat.h
        install -m 0644 ${S}/libavformat/avio.h      ${STAGING_INCDIR}/ffmpeg/avio.h
        install -m 0644 ${S}/libavformat/rtp.h       ${STAGING_INCDIR}/ffmpeg/rtp.h
        install -m 0644 ${S}/libavformat/rtsp.h      ${STAGING_INCDIR}/ffmpeg/rtsp.h
        install -m 0644 ${S}/libavformat/rtspcodes.h ${STAGING_INCDIR}/ffmpeg/rtspcodes.h
}

PACKAGES += "libavcodec libavcodec-dev \ 
             libavformat libavformat-dev"

FILES_libavcodec = "${libdir}/libavcodec*.so.*"
FILES_libavcodec-dev = "${libdir}/libavcodec*.so"
FILES_libavformat = "${libdir}/libavformat*.so.*"
FILES_libavformat-dev = "${libdir}/libavformat*.so"
