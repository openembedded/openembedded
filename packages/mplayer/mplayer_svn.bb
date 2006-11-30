DESCRIPTION = "Open Source multimedia player."
SECTION = "multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl libmad zlib libpng jpeg liba52 freetype fontconfig alsa-lib lzo ncurses lame"
RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "svn://svn.mplayerhq.hu/;module=mplayer \
	   file://vo_w100.c \
	   file://vo_w100_api.h \
	   file://vo_w100_fb.h \
	   file://Makefile-codec-cfg.patch;patch=1 \
	   file://w100-configure.patch;patch=1 \
	   file://w100-Makefile.patch;patch=1 \
	   file://w100-video_out.patch;patch=1 \
	   file://w100-mplayer.patch;patch= \
           file://libmpdemux-ogg-include-svn.patch;patch=1 \
           file://libmpcodecs-ogg-include.patch;patch=1 \
           file://pld-onlyarm5.patch;patch=1"

RCONFLICTS_${PN} = "mplayer-atty"
RREPLACES_${PN} = "mplayer-atty"

PV = "1.0pre8+svn${SRCDATE}"
PR = "r1"
DEFAULT_PREFERENCE = "-1"

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss"

S = "${WORKDIR}/mplayer/trunk/"

PACKAGES =+ "mencoder"

FILES_${PN} = "${bindir}/mplayer"
FILES_mencoder = "${bindir}/mencoder"

inherit autotools pkgconfig

EXTRA_OECONF = " \
        --prefix=/usr \
        --mandir=${mandir} \
        --target=${TARGET_SYS} \
        \
        --enable-mencoder \
        --disable-gui \
        --enable-largefiles \
        --disable-linux-devfs \
        --disable-lirc \
        --disable-lircc \
        --disable-joystick \
        --disable-vm \
        --disable-xf86keysym \
        --disable-tv \
        --disable-tv-v4l \
        --disable-tv-v4l2 \
        --disable-tv-bsdbt848 \
        --enable-rtc \
        --enable-network \
        --disable-winsock2 \
        --disable-smb \
        --disable-live \
        --disable-dvdread \
        --disable-mpdvdkit \
        --disable-cdparanoia \
        --enable-freetype \
        --disable-unrarlib \
        --disable-menu \
        --enable-sortsub \
        --disable-fribidi \
        --disable-enca \
        --disable-macosx \
        --disable-macosx-finder-support \
        --disable-macosx-bundle \
        --disable-ftp \
        --disable-vstream \
        \
        --disable-gif \
        --enable-png \
        --enable-jpeg \
        --disable-libcdio \
        --enable-liblzo \
        --disable-win32 \
        --disable-qtx \
        --disable-xanim \
        --disable-real \
        --disable-xvid \
        --disable-x264 \
        \
        --disable-libavutil_so \
        --disable-libavcodec_so \
        --disable-libavformat_so \
        --disable-libpostproc_so \
        --disable-libfame \
        \
        --enable-tremor-low \
        \
        --disable-speex \
        --disable-theora \
        --disable-faac \
        --disable-ladspa \
        --disable-libdv \
        --enable-mad \
        --disable-toolame \
        --disable-twolame \
        --disable-xmms \
        --disable-mp3lib \
        --disable-libdts \
        --enable-libmpeg2 \
        --disable-musepack \
        --disable-amr_nb \
        --disable-amr_nb-fixed \
        --disable-amr_wb \
        \
        --disable-gl \
        --disable-dga \
        --disable-vesa \
        --disable-svga \
        --enable-sdl \
        --disable-aa \
        --disable-caca \
        --disable-ggi \
        --disable-ggiwmh \
        --disable-directx \
        --disable-dxr2 \
        --disable-dxr3 \
        --disable-dvb \
        --disable-dvbhead \
        --disable-mga \
        --disable-xmga \
        --disable-xv \
        --disable-xvmc \
        --disable-vm \
        --disable-xinerama \
        --disable-x11 \
        --enable-fbdev \
        --disable-mlib \
        --disable-3dfx \
        --disable-tdfxfb \
        --disable-s3fb \
        --disable-directfb \
        --disable-zr \
        --disable-bl \
        --disable-tdfxvid \
        --disable-tga \
        --disable-pnm \
        --disable-md5sum \
        \
        --enable-alsa \
        --enable-ossaudio \
        --disable-arts \
        --disable-esd \
        --disable-polyp \
        --disable-jack \
        --disable-openal \
        --disable-nas \
        --disable-sgiaudio \
        --disable-sunaudio \
        --disable-win32waveout \
        --enable-select \
        \
        --disable-runtime-cpudetection \
        "

EXTRA_OECONF_append_c7x0 = " --enable-w100 "

do_configure() {
	cp ${WORKDIR}/vo_w100.c ${S}/libvo
	cp ${WORKDIR}/vo_w100_api.h ${S}/libvo
	cp ${WORKDIR}/vo_w100_fb.h ${S}/libvo
        ./configure ${EXTRA_OECONF}
}

do_compile () {
	oe_runmake
}

