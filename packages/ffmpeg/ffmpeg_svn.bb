require ffmpeg.inc

DEPENDS += "libogg"

PV = "0.4.9+svnr${SRCREV}" 
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.mplayerhq.hu/ffmpeg/;module=trunk"

S = "${WORKDIR}/trunk"

EXTRA_OECONF += " \
        --enable-libmp3lame \
        --enable-libvorbis \
        --disable-libfaad \
        --enable-liba52 \
        --enable-liba52bin \
        --enable-libogg \
        --enable-gpl \
        \
        --disable-strip \
        \
        \
        --cpu=${PACKAGE_ARCH} \
        --arch=${PACKAGE_ARCH} \
"

oe_runconf () {
        # make ffmpeg detect arm targets that don't end in 'l'
        sed -i -e s:'armv\[4567\]\*l':'armv\[4567\]\*':g ${S}/configure
        if [ -x ${S}/configure ] ; then
                cfgcmd="${S}/configure \
                        --prefix=${prefix} \
                        --mandir=${mandir} \
                        ${EXTRA_OECONF} \
                    $@"
                oenote "Running $cfgcmd..."
                $cfgcmd || oefatal "oe_runconf failed"
        else
                oefatal "no configure script found"
        fi

}

do_stage() {
        oe_libinstall -a -so -C libavcodec libavcodec ${STAGING_LIBDIR}
        oe_libinstall -a -so -C libavdevice libavdevice ${STAGING_LIBDIR}
        oe_libinstall -a -so -C libavformat libavformat ${STAGING_LIBDIR}
        oe_libinstall -a -so -C libavutil libavutil ${STAGING_LIBDIR}
        oe_libinstall -a -so -C libpostproc libpostproc ${STAGING_LIBDIR}

        install -d ${STAGING_INCDIR}/ffmpeg
        install -m 0644 ${S}/libavcodec/avcodec.h \
                ${STAGING_INCDIR}/ffmpeg/avcodec.h
        install -m 0644 ${S}/libavdevice/avdevice.h \
                ${STAGING_INCDIR}/ffmpeg/avdevice.h
        install -m 0644 ${S}/libavformat/avformat.h \
                ${STAGING_INCDIR}/ffmpeg/avformat.h
        install -m 0644 ${S}/libavformat/avio.h \
                ${STAGING_INCDIR}/ffmpeg/avio.h
        install -m 0644 ${S}/libavformat/rtp.h \
                ${STAGING_INCDIR}/ffmpeg/rtp.h
        install -m 0644 ${S}/libavformat/rtsp.h \
                ${STAGING_INCDIR}/ffmpeg/rtsp.h
        install -m 0644 ${S}/libavformat/rtspcodes.h \
                ${STAGING_INCDIR}/ffmpeg/rtspcodes.h

        install -m 0644 ${S}/libavutil/avutil.h \
                ${STAGING_INCDIR}/ffmpeg/avutil.h
        install -m 0644 ${S}/libavutil/bswap.h \
                ${STAGING_INCDIR}/ffmpeg/bswap.h
        install -m 0644 ${S}/libavutil/common.h \
                ${STAGING_INCDIR}/ffmpeg/common.h
        install -m 0644 ${S}/libavutil/crc.h \
                ${STAGING_INCDIR}/ffmpeg/crc.h
        install -m 0644 ${S}/libavutil/integer.h \
                ${STAGING_INCDIR}/ffmpeg/integer.h
        install -m 0644 ${S}/libavutil/intfloat_readwrite.h \
                ${STAGING_INCDIR}/ffmpeg/intfloat_readwrite.h
        install -m 0644 ${S}/libavutil/mathematics.h \
                ${STAGING_INCDIR}/ffmpeg/mathematics.h
        install -m 0644 ${S}/libavutil/rational.h \
                ${STAGING_INCDIR}/ffmpeg/rational.h
        install -m 0644 ${S}/libavutil/mem.h \
                ${STAGING_INCDIR}/ffmpeg/mem.h
        install -m 0644 ${S}/libavutil/log.h \
                ${STAGING_INCDIR}/ffmpeg/log.h

        install -d ${STAGING_INCDIR}/libpostproc
        install -m 0644 ${S}/libpostproc/postprocess.h \
                ${STAGING_INCDIR}/libpostproc/postprocess.h
}

PACKAGES += "libavcodec libavcodec-dev \
        libavdevice libavdevice-dev \
        libavformat libavformat-dev \
        libavutil libavutil-dev \
        libpostproc libpostproc-dev"

FILES_${PN} = "${bindir} ${libdir}/vhook"
FILES_${PN}-dev += "${bindir} ${libdir}/pkgconfig/libswscale.pc"
FILES_${PN}-doc = "${mandir}"

FILES_libavcodec = "${libdir}/libavcodec*.so.*"
FILES_libavcodec-dev = "${libdir}/libavcodec*.so \
        ${libdir}/pkgconfig/libavcodec.pc \
        ${libdir}/libavcodec*.la ${libdir}/libavcodec*.a"

FILES_libavdevice = "${libdir}/libavdevice*.so.*"
FILES_libavdevice-dev = "${libdir}/libavdevice*.so \
        ${libdir}/pkgconfig/libavdevice.pc \
        ${libdir}/libavdevice*.la ${libdir}/libavdevice*.a"

FILES_libavformat = "${libdir}/libavformat*.so.*"
FILES_libavformat-dev = "${libdir}/libavformat*.so \
        ${libdir}/pkgconfig/libavformat.pc \
        ${libdir}/libavformat*.la ${libdir}/libavformat*.a"

FILES_libavutil = "${libdir}/libavutil*.so.*"
FILES_libavutil-dev = "${libdir}/libavutil*.so \
        ${libdir}/pkgconfig/libavutil.pc \
        ${libdir}/libavutil*.la ${libdir}/libavutil*.a"

FILES_libpostproc = "${libdir}/libpostproc*.so.*"
FILES_libpostproc-dev = "${libdir}/libpostproc*.so \
        ${libdir}/pkgconfig/libpostproc.pc \
        ${libdir}/libpostproc*.la ${libdir}/libpostproc*.a"
