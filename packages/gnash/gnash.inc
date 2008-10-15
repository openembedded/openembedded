DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPL-2"
DEPENDS = "libtool ffmpeg gtk+ cairo libxml2 libmad libsdl-mixer zlib boost jpeg pango curl freetype"
PR = "r2"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gnash/${PV}/gnash-${PV}.tar.bz2 \
          "

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=cairo \
                --enable-media=ffmpeg \
                --disable-klash \
                --enable-z \
                --enable-jpeg \
                --disable-glext \
                --enable-Xft \
                --enable-expat \
                --enable-mad \
                --enable-cairo \
                --enable-plugin \
                --disable-cygnal \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                "

PACKAGES =+ " libgnashamf libgnashbackend libgnashbase libgnashgeo libgnashgui libgnashplayer libgnashserver "

FILES_libgnashamf = "${libdir}/gnash/libgnashamf-${PV}.so"
FILES_libgnashbackend = "${libdir}/gnash/libgnashbackend-${PV}.so"
FILES_libgnashbase = "${libdir}/gnash/libgnashbase-${PV}.so"
FILES_libgnashgeo = "${libdir}/gnash/libgnashgeo-${PV}.so"
FILES_libgnashgui = "${libdir}/gnash/libgnashgui-${PV}.so"
FILES_libgnashplayer = "${libdir}/gnash/libgnashplayer-${PV}.so"
FILES_libgnashserver = "${libdir}/gnash/libgnashserver-${PV}.so"

PARALLEL_MAKE = ""
