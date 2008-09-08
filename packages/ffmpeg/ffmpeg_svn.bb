require ffmpeg.inc

DEPENDS += "libgsm"

SRCREV ?= "12186"

PE = "1"
PV = "0.4.9+svnr${SRCREV}" 
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.mplayerhq.hu/ffmpeg/;module=trunk"

S = "${WORKDIR}/trunk"

EXTRA_OECONF += " \
        --prefix=/usr \
        \
        --enable-nonfree \
        --enable-swscaler \
        --enable-x11grab \
        \
        --enable-liba52 \
        --enable-liba52bin \
        --enable-libfaac \
        --enable-libfaad \
        --enable-libfaadbin \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libvorbis \
        \
        --arch=${TARGET_ARCH} \
        --cross-compile \
        --cc="gcc ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-cflags="${TARGET_CFLAGS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --enable-hardcoded-tables \
"

do_configure() {
         ${S}/configure ${EXTRA_OECONF}
}

do_stage() {
        for lib in libavcodec libavdevice libavformat \
                   libavutil libpostproc libswscale
        do
            oe_libinstall -a -so -C $lib $lib ${STAGING_LIBDIR}
        done 

        install -d ${STAGING_INCDIR}/ffmpeg

        install -m 0644 ${S}/libavcodec/avcodec.h ${STAGING_INCDIR}/ffmpeg/avcodec.h
        install -m 0644 ${S}/libavcodec/opt.h ${STAGING_INCDIR}/ffmpeg/opt.h

        install -m 0644 ${S}/libavdevice/avdevice.h  ${STAGING_INCDIR}/ffmpeg/avdevice.h
        
        for h in avformat.h avio.h rtp.h rtsp.h rtspcodes.h
        do
           install -m 0644 ${S}/libavformat/$h  ${STAGING_INCDIR}/ffmpeg/$h
        done

        for h in adler32.h avstring.h avutil.h base64.h bswap.h \
                 common.h crc.h fifo.h integer.h intfloat_readwrite.h \
                 log.h lzo.h mathematics.h md5.h mem.h random.h \
                 rational.h sha1.h
        do
           install -m 0644 ${S}/libavutil/$h        ${STAGING_INCDIR}/ffmpeg/$h
        done

        install -m 0644 ${S}/libswscale/swscale.h ${STAGING_INCDIR}/ffmpeg/swscale.h
        install -m 0644 ${S}/libswscale/rgb2rgb.h ${STAGING_INCDIR}/ffmpeg/rgb2rgb.h

        install -d ${STAGING_INCDIR}/libpostproc
        install -m 0644 ${S}/libpostproc/postprocess.h ${STAGING_INCDIR}/libpostproc/postprocess.h
}

PACKAGES += "libavcodec  libavcodec-dev  libavcodec-dbg \
             libavdevice libavdevice-dev libavdevice-dbg \
             libavformat libavformat-dev libavformat-dbg \
             libavutil   libavutil-dev   libavutil-dbg \
             libpostproc libpostproc-dev libpostproc-dbg \
             libswscale  libswscale-dev  libswscale-dbg"

FILES_libavcodec = "${libdir}/libavcodec*.so.*"
FILES_libavcodec-dev = "${libdir}/libavcodec*.so ${libdir}/pkgconfig/libavcodec.pc ${libdir}/libavcodec*.a"
FILES_libavcodec-dbg += "${libdir}/.debug/libavcodec*"

FILES_libavdevice = "${libdir}/libavdevice*.so.*"
FILES_libavdevice-dev = "${libdir}/libavdevice*.so ${libdir}/pkgconfig/libavdevice.pc ${libdir}/libavdevice*.a"
FILES_libavdevice-dbg += "${libdir}/.debug/libavdevice*"

FILES_libavformat = "${libdir}/libavformat*.so.*"
FILES_libavformat-dev = "${libdir}/libavformat*.so ${libdir}/pkgconfig/libavformat.pc ${libdir}/libavformat*.a"
FILES_libavformat-dbg += "${libdir}/.debug/libavformat*"

FILES_libavutil = "${libdir}/libavutil*.so.*"
FILES_libavutil-dev = "${libdir}/libavutil*.so ${libdir}/pkgconfig/libavutil.pc ${libdir}/libavutil*.a"
FILES_libavutil-dbg += "${libdir}/.debug/libavutil*"

FILES_libpostproc = "${libdir}/libpostproc*.so.*"
FILES_libpostproc-dev = "${libdir}/libpostproc*.so  ${libdir}/pkgconfig/libpostproc.pc ${libdir}/libpostproc*.a ${includedir}/postproc"
FILES_libpostproc-dbg += "${libdir}/.debug/libpostproc*"

FILES_libswscale = "${libdir}/libswscale*.so.*"
FILES_libswscale-dev = "${libdir}/libswscale*.so ${libdir}/pkgconfig/libswscale.pc ${libdir}/libswscale*.a"
FILES_libswscale-dbg += "${libdir}/.debug/libswscale*"
