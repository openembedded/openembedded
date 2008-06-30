DESCRIPTION = "Video player and streamer - GPE edition"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "multimedia"

SRCREV = "844af286e4675d25bbefd9164b4df29609264a86"

PV = "0.8.6h+${PR}+gitr${SRCREV}"

DEPENDS = "gnutls tremor faad2 ffmpeg flac liba52 libid3tag libmad mpeg2dec"

SRC_URI = "git://git.videolan.org/vlc.git;protocol=git;branch=0.8.6-neuros"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "\
    --with-contrib \
	--disable-dvdread \
	--disable-wxwidgets \
    --disable-skins2 \
	--disable-libmpeg2 \
    --disable-dvdnav \
	--disable-x11 --disable-xvideo --disable-opengl --disable-glx \
	--disable-screen --disable-caca \
	--disable-httpd --disable-vlm \
	--disable-freetype \
    --disable-sdl \ 
    --enable-png \
	--enable-live555 --enable-tremor \
    --disable-mod \
	--enable-davinci --enable-davincifb --enable-davinciresizer \
    --enable-v4l2 --enable-aa --enable-wma --enable-faad \
    --disable-dbus \
"


do_configure() {
	./bootstrap	
	gnu-configize
	libtoolize --force
	autoreconf --force -i
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

RCONFLICTS_${PN} = "vlc"

FILES_${PN} += "${bindir}/vlc \
	${datadir}/applications \
	${datadir}/vlc/ \
	"
