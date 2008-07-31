require ffmpeg.inc

DEPENDS += "libgsm"

PV = "0.4.9+${PR}+gitr${SRCREV}" 
PR = "r19"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_armv5te = "1"
DEFAULT_PREFERENCE_armv6 = "1"
DEFAULT_PREFERENCE_armv7a = "1"

FFBRANCH_arm = "arm-neon"
FFBRANCH ?= "master"

SRCREV = "3692b8de9fae73860be636606cb6344f26e28b1a"
SRCREV_arm = "a3f0e289611cb79254ea8ba01923a6693422679d"
SRC_URI = "git://git.mansr.com/ffmpeg.mru;protocol=git;branch=${FFBRANCH} \
"

S = "${WORKDIR}/git"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF ?= ""

EXTRA_OECONF = " \
        --enable-shared \
        --enable-pthreads \
        --disable-stripping \
        --enable-gpl \
        --enable-nonfree \
        --enable-postproc \
        \
        --cross-prefix=${TARGET_PREFIX} \
        --prefix=${prefix} \
        \
        --enable-x11grab \
        --enable-libfaac \
        --enable-libfaad \
        --enable-libfaadbin \
        --enable-libgsm \
        --enable-libmp3lame \
        --disable-swscale \
        --arch=${TARGET_ARCH} \
        --enable-cross-compile \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --enable-hardcoded-tables \
        ${EXTRA_FFCONF} \
"

do_configure() {
        cd ${S} ; git clone git://git.mplayerhq.hu/libswscale || true  
        mkdir -p ${B}
        cd ${B}
        ${S}/configure ${EXTRA_OECONF}
		sed -i -e s:Os:O4:g ${B}/config.h
}

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

		for h in adler32.h avstring.h avutil.h base64.h bswap.h \
                 common.h crc.h fifo.h integer.h intfloat_readwrite.h \
                 log.h lzo.h mathematics.h md5.h mem.h random.h \
                 rational.h sha1.h
		do
           install -m 0644 ${S}/libavutil/$h        ${STAGING_INCDIR}/ffmpeg/$h
           install -m 0644 ${S}/libavutil/$h        ${STAGING_INCDIR}/libavutil/$h 
        done

        install -m 0644 ${S}/libswscale/swscale.h ${STAGING_INCDIR}/ffmpeg/swscale.h
        install -m 0644 ${S}/libswscale/rgb2rgb.h ${STAGING_INCDIR}/ffmpeg/rgb2rgb.h

        install -d ${STAGING_INCDIR}/libpostproc
        install -d ${STAGING_INCDIR}/postproc 
        install -m 0644 ${S}/libpostproc/postprocess.h ${STAGING_INCDIR}/libpostproc/postprocess.h
        install -m 0644 ${S}/libpostproc/postprocess.h ${STAGING_INCDIR}/postproc/postprocess.h
}

PACKAGES += "libavcodec  libavcodec-dev  libavcodec-dbg \
             libavdevice libavdevice-dev libavdevice-dbg \
             libavformat libavformat-dev libavformat-dbg \
             libavutil   libavutil-dev   libavutil-dbg \
             libpostproc libpostproc-dev libpostproc-dbg \
             libswscale  libswscale-dev  libswscale-dbg"

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
