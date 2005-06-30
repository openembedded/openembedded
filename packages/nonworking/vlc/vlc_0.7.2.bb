
DESCRIPTION = "vlc"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "liba52 libmad libmpeg2 ffmpeg libogg libvorbis faad2 mplayer"

inherit autotools

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/${PN}-${PV}.tar.gz \
	"


EXTRA_OECONF=" \
  --enable-release \
  --prefix=/usr \
  --enable-sout \
  --disable-livedotcom \
  --disable-dvd \
  --disable-dvdread \
  --disable-dvdplay \
  --disable-dvdnav \
  --disable-dshow \
  --disable-dvbpsi \
  --disable-v4l \
  --disable-pvr \
  --disable-libcdio \
  --disable-libcddb \
  --disable-vcdx \
  --disable-cdda \
  --disable-cddax \
  --disable-vcd \
  --disable-satellite \
  --disable-dvb \
  --enable-ogg \
  --disable-mkv \
  --enable-mod \
  --enable-mad \
  --enable-ffmpeg \
  --enable-faad \
  --disable-quicktime \
  --enable-a52 \
  --disable-dts \
  --enable-flac \
  --enable-libmpeg2 \
  --disable-vorbis \
  --enable-tremor \
  --disable-speex \
  --disable-tarkin \
  --disable-theora \
  --disable-cmml \
  --disable-x11 \
  --disable-xvideo \
  --enable-sdl \
  --disable-freetype \
  --disable-fribidi \
  --enable-qte \
  --disable-directx \
  --enable-fb \
  --disable-mga \
  --disable-svgalib \
  --disable-ggi \
  --disable-glide \
  --disable-aa \
  --disable-caca \
  --disable-wingdi \
  --enable-oss \
  --disable-esd \
  --disable-arts \
  --disable-alsa \
  --disable-waveout \
  --disable-coreaudio \
  --disable-hd1000a \
  --disable-skins \
  --disable-skins2 \
  --disable-gtk \
  --disable-pda \
  --disable-gnome \
  --disable-wxwindows \
  --disable-qt \
  --disable-kde \
  --enable-opie \
  --disable-macosx \
  --disable-qnx \
  --disable-ncurses \
  --disable-xosd \
  --disable-visual \
  --disable-goom \
  --enable-slp \
  --disable-lirc \
  --disable-joystick \
  --disable-corba \
  --disable-mozilla \
  --disable-testsuite \
"


##do_stage() {
##	oe_libinstall -a -so -C libavcodec libavcodec ${STAGING_LIBDIR}
##	oe_libinstall -a -so -C libavformat libavformat ${STAGING_LIBDIR}
##
##	install -d ${STAGING_INCDIR}/ffmpeg
##	install -m 0644 ${S}/libavcodec/avcodec.h ${STAGING_INCDIR}/ffmpeg/avcodec.h
##	install -m 0644 ${S}/libavcodec/common.h ${STAGING_INCDIR}/ffmpeg/common.h
##	install -m 0644 ${S}/libavcodec/rational.h ${STAGING_INCDIR}/ffmpeg/rational.h
##	install -m 0644 ${S}/libavformat/avformat.h ${STAGING_INCDIR}/ffmpeg/avformat.h
##	install -m 0644 ${S}/libavformat/avio.h ${STAGING_INCDIR}/ffmpeg/avio.h
##	install -m 0644 ${S}/libavformat/rtp.h ${STAGING_INCDIR}/ffmpeg/rtp.h
##	install -m 0644 ${S}/libavformat/rtsp.h ${STAGING_INCDIR}/ffmpeg/rtsp.h
##	install -m 0644 ${S}/libavformat/rtspcodes.h ${STAGING_INCDIR}/ffmpeg/rtspcodes.h
##}
