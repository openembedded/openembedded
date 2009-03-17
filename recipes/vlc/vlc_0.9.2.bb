DESCRIPTION = "Video player and streamer - davinci edition"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "multimedia"

PR = "r2"

DEPENDS = "libtool hal gettext libgcrypt schroedinger libsdl-x11 qt4-x11-free dbus libxml2 gnutls tremor faad2 ffmpeg flac \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag liba52 mpeg2dec', d)}"

SRC_URI = "http://videolan.mirror.technotop.nl/vlc/0.9.2/vlc-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "\
	--enable-libtool \
	--with-contrib \
	--disable-dvdread \
	--disable-wxwidgets \
	--enable-x11 --enable-xvideo \ 
	--disable-screen --disable-caca \
	--enable-httpd --enable-vlm \
	--enable-freetype \
	--enable-sdl \ 
	--enable-png \
	--enable-live555 --enable-tremor \
	--enable-v4l2 --enable-v4l --disable-aa --enable-wma --disable-faad \
	--enable-dbus \
	--enable-hal \	
	--without-contrib \
	ac_cv_path_MOC=${STAGING_BINDIR_NATIVE}/moc4 \
	ac_cv_path_RCC=${STAGING_BINDIR_NATIVE}/rcc4 \
	ac_cv_path_UIC=${STAGING_BINDIR_NATIVE}/uic4 \
"


do_configure() {
	cp ${STAGING_DATADIR}/aclocal/libgcrypt.m4 ${S}/m4/ 
	./bootstrap	
	gnu-configize --force
	libtoolize --force
	#autoreconf --force -i
	cp ${STAGING_DATADIR}/libtool/config.* ${S}/autotools/
	oe_runconf
	rm config.log
	sed -i -e s:-L/usr/lib:-L${STAGING_LIBDIR}/:g vlc-config
	sed -i -e s:'$(MOC) $(DEFS) $(CPPFLAGS)':'$(MOC) $(DEFS)'\ -I${S}/include\ -DSYS_LINUX:g ${S}/modules/gui/qt4/Makefile
}

do_stage() {
	autotools_stage_all
}


FILES_${PN} += "${bindir}/vlc \
	${datadir}/applications \
	${datadir}/vlc/ \
	"

FILES_${PN}-dbg	+= "${libdir}/vlc/*/.debug"
