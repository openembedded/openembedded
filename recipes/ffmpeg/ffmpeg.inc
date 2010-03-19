DESCRIPTION = "FFmpeg is a complete solution to record, convert and stream audio and video"
HOMEPAGE = "http://ffmpeg.mplayerhq.hu/"
AUTHOR = "Fabrice Bellard ffmpeg-devel@mplayerhq.hu"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "zlib libogg libvorbis libtheora faac faad2 ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'lame liba52', d)}"
RSUGGESTS = "mplayer"

INC_PR = "r13"

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

FFMPEG_LIBS = "libavcodec libavdevice libavformat \
               libavutil libpostproc libswscale"

SYSROOT_PREPROCESS_FUNCS = " \
  ffmpeg_stage_cleanup \
  ffmpeg_create_compat_links"

ffmpeg_create_compat_links() {
        rm -rf ${SYSROOT_DESTDIR}${STAGING_INCDIR}/ffmpeg
        mkdir -m 0755 ${SYSROOT_DESTDIR}${STAGING_INCDIR}/ffmpeg
        cd ${SYSROOT_DESTDIR}${STAGING_INCDIR}/ffmpeg

        for lib in ${FFMPEG_LIBS}; do
                ln -s ../$lib/*.h '.'
        done
}

ffmpeg_stage_cleanup() {
        rm -rf ${SYSROOT_DESTDIR}${STAGING_LIBDIR}/vhook \
        ${SYSROOT_DESTDIR}${STAGING_DATADIR}
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
