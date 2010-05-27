DESCRIPTION = "Video player and streamer - davinci edition"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "multimedia"

SRCREV = "e712a114e04a1070f1afdf31ec668cb28eda513c"

PR = "r6"

PV = "0.8.6h+${PR}+gitr${SRCREV}"

DEPENDS = "codec-engine dbus libxml2 gnutls tremor faad2 ffmpeg flac  \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag liba52 mpeg2dec', d)}"

SRC_URI = "git://git.videolan.org/vlc.git;protocol=git;branch=0.8.6-neuros"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "\
    --enable-libtool \
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
    --enable-v4l2 --disable-aa --enable-wma --disable-faad \
    --enable-dbus \
"


do_configure() {
	./bootstrap	
	gnu-configize
	libtoolize --force
	autoreconf --force -i
	oe_runconf
	rm config.log
	sed -i -e s:-L/usr/lib:-L${STAGING_LIBDIR}/:g vlc-config
}

do_stage() {
	autotools_stage_all
}

RCONFLICTS_${PN} = "vlc"

FILES_${PN} += "${bindir}/vlc \
	${datadir}/applications \
	${datadir}/vlc/ \
	"
