DESCRIPTION = "FFmpeg is a complete solution to record, convert and stream audio and video"
HOMEPAGE = "http://ffmpeg.mplayerhq.hu/"
AUTHOR = "Fabrice Bellard ffmpeg-devel@mplayerhq.hu"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "zlib libogg libvorbis libtheora faac faad2 ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'lame liba52', d)}"
RSUGGESTS = "mplayer"

INC_PR = "r12"

inherit autotools pkgconfig

LEAD_SONAME = "libavcodec.so"

EXTRA_OECONF = "\
        \
        --enable-pp \
        --enable-shared \
        --enable-pthreads \
        --enable-gpl \
        \
        --cross-prefix=${TARGET_PREFIX} \
        --disable-debug \
        --disable-ffserver \
        --disable-ffplay \
        \
"

do_stage() {
        for lib in libavcodec libavdevice libavformat \
                   libavutil libpostproc libswscale
        do
            oe_libinstall -a -so -C $lib $lib ${STAGING_LIBDIR} || true
            install -d ${STAGING_INCDIR}/$lib 
        done 

        install -d ${STAGING_INCDIR}/ffmpeg

        install -m 0644 ${S}/libavcodec/avcodec.h ${STAGING_INCDIR}/ffmpeg/avcodec.h
        install -m 0644 ${S}/libavcodec/opt.h ${STAGING_INCDIR}/ffmpeg/opt.h
        install -m 0644 ${S}/libavcodec/avcodec.h ${STAGING_INCDIR}/libavcodec/avcodec.h
        install -m 0644 ${S}/libavcodec/opt.h ${STAGING_INCDIR}/libavcodec/opt.h

        install -m 0644 ${S}/libavdevice/avdevice.h  ${STAGING_INCDIR}/ffmpeg/avdevice.h
        
        for h in avformat.h avio.h rtp.h rtsp.h rtspcodes.h
        do
           install -m 0644 ${S}/libavformat/$h  ${STAGING_INCDIR}/ffmpeg/$h
           install -m 0644 ${S}/libavformat/$h  ${STAGING_INCDIR}/libavformat/$h	
	done

		for h in adler32.h aes.h attributes.h avstring.h avutil.h base64.h bswap.h common.h crc_data.h crc.h des.h error.h fifo.h integer.h internal.h intfloat_readwrite.h intmath.h intreadwrite.h lfg.h libm.h lls.h log.h lzo.h mathematics.h md5.h mem.h pca.h pixdesc.h pixfmt.h random_seed.h rational.h rc4.h sha1.h sha.h softfloat.h timer.h tree.h x86_cpu.h
		do
           install -m 0644 ${S}/libavutil/$h        ${STAGING_INCDIR}/ffmpeg/$h
           install -m 0644 ${S}/libavutil/$h        ${STAGING_INCDIR}/libavutil/$h 
        done
        install -m 0644 ${B}/libavutil/avconfig.h ${STAGING_INCDIR}/ffmpeg/
        install -m 0644 ${B}/libavutil/avconfig.h ${STAGING_INCDIR}/libavutil/

        install -d ${STAGING_INCDIR}/libswscale/ 
        install -m 0644 ${S}/libswscale/*.h ${STAGING_INCDIR}/ffmpeg/
        install -m 0644 ${S}/libswscale/*.h ${STAGING_INCDIR}/libswscale/

        install -d ${STAGING_INCDIR}/libpostproc
        install -d ${STAGING_INCDIR}/postproc 
        install -m 0644 ${S}/libpostproc/postprocess.h ${STAGING_INCDIR}/libpostproc/postprocess.h
        install -m 0644 ${S}/libpostproc/postprocess.h ${STAGING_INCDIR}/postproc/postprocess.h
}


PACKAGES += "${PN}-vhook-dbg ${PN}-vhook"

FILES_${PN} = "${bindir}"
FILES_${PN}-dev = "${includedir}/${PN}"

FILES_${PN}-vhook = "${libdir}/vhook"
FILES_${PN}-vhook-dbg += "${libdir}/vhook/.debug"


PACKAGES += "ffmpeg-x264-presets \
             libavcodec  libavcodec-dev  libavcodec-dbg \
             libavdevice libavdevice-dev libavdevice-dbg \
             libavformat libavformat-dev libavformat-dbg \
             libavutil   libavutil-dev   libavutil-dbg \
             libpostproc libpostproc-dev libpostproc-dbg \
             libswscale  libswscale-dev  libswscale-dbg"

FILES_ffmpeg-x264-presets = "${datadir}/*.ffpreset"

FILES_${PN}-dev = "${includedir}"
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
