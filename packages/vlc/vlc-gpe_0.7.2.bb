DESCRIPTION = "Video player and streamer - GPE edition"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"
PR = "r1"

DEPENDS = "faad2 ffmpeg flac liba52 libid3tag libmad mpeg2dec"

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/vlc-${PV}.tar.gz"
S = "${WORKDIR}/vlc-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-plugins \
	--disable-gtk \
	--disable-gtk2 \
	--disable-gnome \
	--disable-gnome2 \
	--disable-qt \
	--disable-kde \
	--disable-qte \
	--disable-xosd \
	--disable-ogg \
	--disable-tarkin \
	--disable-tremor \
	--disable-theorea \
	--disable-skins \
	--disable-skins2 \
	--disable-sdl \
	--disable-v4l \
	--enable-sout \
	--enable-dummy \
	--enable-fb \
	--enable-oss \
	--disable-alsa \
	--enable-x11 \
	--disable-xvideo \
	--disable-dvd \
	--disable-dvdplay \
	--disable-dvdread \
	--disable-dvdnav \
	--disable-libcdio \
	--disable-libcddb \
	--disable-vcdx \
	--disable-vcd \
	--disable-maxosx \
	--disable-goom \
	--disable-speex \
	--disable-visual \
	--enable-freetype \
	--disable-fribidi \
	--enable-a52 \
	--enable-faad \
	--enable-flac \
	--enable-libmpeg2 \
	--enable-dvbpsi \
	--disable-mkv \
	--enable-mad \
	--enable-id3tag \
	--enable-ffmpeg \
	--disable-slp \
	--enable-pda \
	--with-ffmpeg-mp3lame \
	--with-ffmpeg-faac"

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
