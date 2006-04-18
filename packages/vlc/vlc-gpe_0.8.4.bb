DESCRIPTION = "Video player and streamer - GPE edition"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"
PR = "r1"

DEPENDS = "gtk+ freetype gnutls tremor faad2 ffmpeg flac liba52 libid3tag libmad mpeg2dec"

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/vlc-${PV}.tar.gz \
	file://pda-interface.patch;patch=1"
S = "${WORKDIR}/vlc-${PV}"

export GTK2_CFLAGS  = "`pkg-config --cflags gtk+-2.0 gthread-2.0`"
export GTK2_LIBS  = "`pkg-config --libs gtk+-2.0 gthread-2.0`"
export vlc_WORKAROUNDLDFLAGS = lib/libvlc.a

inherit autotools

EXTRA_OECONF = "\
	--enable-sout \
	--disable-httpd \
	--disable-vlm \
	--enable-gnutls \
	--disable-dvdread \
	--disable-dvdnav \
        --disable-smb \
	--enable-dvbpsi \
	--disable-v4l \
	--disable-gnomevfs \
	--disable-libcdio \
	--disable-cddax \
	--disable-libcddb \
	--disable-vcdx \
	--disable-cdda \
	--disable-vcd \
        --disable-screen \
	--disable-ogg \
	--disable-mkv \
	--disable-mod \
	--disable-mpc \
	--enable-mad \
	--enable-ffmpeg \
	--enable-faad \
	--enable-a52 \
        --disable-dts \
	--enable-flac \
	--enable-libmpeg2 \
        --disable-vorbis \
	--enable-tremor \
	--disable-speex \
	--disable-tarkin \
	--disable-theora \
        --disable-png \
        --disable-x264 \
	--disable-cmml \
	--enable-x11 \
	--disable-xvideo \
	--disable-glx \
	--disable-opengl \
        --disable-sdl \
	--enable-freetype \
	--disable-fribidi \
        --disable-libxml2 \
	--disable-qte \
	--disable-qt-video \
	--enable-fb \
	--enable-oss \
	--disable-alsa \
	--disable-skins \
	--disable-skins2 \
	--disable-gtk \
	--disable-gtk2 \
	--enable-pda \
	--disable-gnome \
	--disable-gnome2 \
	--disable-wxwidgets \
	--disable-qt \
	--disable-kde \
	--disable-xosd \
	--disable-visual \
	--disable-goom \
	--disable-slp \
	--disable-daap \
	--disable-bonjour \
	--disable-joystick \
	--disable-plugins \
	--with-ffmpeg-mp3lame \
	--with-ffmpeg-faac \
	--with-ffmpeg-zlib \
"

do_install() {
	autotools_do_install

	install -d ${D}${datadir}/applications
	install -m 644 ipkg/vlc.gpe ${D}${datadir}/applications/vlc-gpe.desktop
}

FILES_${PN} = "${bindir}/vlc \
	${datadir}/applications \
	${datadir}/vlc/pda-* \
	${datadir}/vlc/vlc*png \
	${datadir}/vlc/vlc*xpm \
	${datadir}/vlc/http"
