DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"

LICENSE = "GPL-2"
HOMEPAGE = "http://www.gnu.org/software/gnash"

DEPENDS = "gtk+ cairo libxml2 libmad libsdl-mixer zlib boost jpeg pango curl"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gnash/${PV}/gnash-${PV}.tar.bz2"


EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=cairo \
		--enable-media=none \
                --disable-klash \
		--enable-z \
		--enable-jpeg \
		--disable-glext \
		--enable-Xft \
		--enable-expat \
		--enable-mad \
		--enable-cairo \
		--disable-plugin \
		--disable-cygnal \
		--with-boost-incl=${STAGING_INCDIR} \
		--with-boost-lib=${STAGING_LIBDIR} \
		--with-libxml-incl=${STAGING_INCDIR}/libxml2 \
		--with-libxml-lib=${STAGING_LIBDIR} \
		--with-glib-incl=${STAGING_INCDIR}/glib-2.0 \
#		--with-glib-lib=${STAGING_LIBDIR} \
		--with-gtk2-incl=${STAGING_INCDIR}/gtk-2.0 \
		--with-pango-incl=${STAGING_INCDIR}/pango-1.0 \
#		--with-pango-lib=${STAGING_LIBDIR} \
		--with-sdl-incl=${STAGING_INCDIR}/SDL \
		--with-atk-incl=${STAGING_INCDIR}/atk-1.0 \
		--with-Xft-incl=${STAGING_INCDIR}/X11 \
		--with-expat-incl=${STAGING_INCDIR} \
		--with-mad-incl=${STAGING_INCDIR} \
		--with-cairo-incl=${STAGING_INCDIR}/cairo \
		--with-curl-incl=${STAGING_INCDIR} \
		--with-curl-lib=${STAGING_LIBDIR} \
		" 

inherit autotools pkgconfig

LDFLAGS += " -L${STAGING_LIBDIR} -lcurl  -lboost_date_time -lboost_filesystem -lboost_iostreams -lboost_signals -lboost_thread-mt "
CFLAGS += " -I${STAGING_INCDIR} -I${STAGING_LIBDIR}/gtk-2.0/include/ "

do_configure_append() {
        for i in `find . -name Makefile` ; do
		sed -i s:I/usr/include:I${STAGING_INCDIR}:g $i
	done
}


PARALLEL_MAKE = ""

do_compile() {
        oe_runmake 'CC=${CC}' 'LD=${LD}' 'CFLAGS=${CFLAGS}' \
                   'ZLIB_INCLUDE=${STAGING_INCDIR}' \
                   'ZLIB_LIBS=${STAGING_LIBDIR}' \
		   'PNG_INCLUDE=${STAGING_INCDIR}' \	
		   'PNG_LIBS=${STAGING_LIBDIR}'
}


PACKAGES =+ " libgnashamf libgnashbackend libgnashbase libgnashgeo libgnashgui libgnashplayer libgnashserver "

FILES_libgnashamf = "${libdir}/libgnashamf-${PV}.so"
FILES_libgnashbackend = "${libdir}/libgnashbackend-${PV}.so"
FILES_libgnashbase = "${libdir}/libgnashbase-${PV}.so"
FILES_libgnashgeo = "${libdir}/libgnashgeo-${PV}.so"
FILES_libgnashgui = "${libdir}/libgnashgui-${PV}.so"
FILES_libgnashplayer = "${libdir}/libgnashplayer-${PV}.so"
FILES_libgnashserver = "${libdir}/libgnashserver-${PV}.so"

do_stage() {
        autotools_stage_all
}

