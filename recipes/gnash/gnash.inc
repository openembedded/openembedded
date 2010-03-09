DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPLv2"
DEPENDS = "giflib libtool gtk+ cairo libxml2 libsdl-mixer zlib boost jpeg pango curl freetype \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'ffmpeg libmad', d)}"
          
PR = "r6"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gnash/${PV}/gnash-${PV}.tar.bz2 \
          "

inherit autotools pkgconfig siteinfo

EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=cairo \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-media=ffmpeg', d)} \
                --disable-klash \
                --enable-z \
                --enable-jpeg \
                --disable-glext \
                --enable-Xft \
                --enable-expat \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-mad', d)} \
                --enable-cairo \
                --enable-plugin \
                --enable-plugins \
                --enable-npapi \
                --with-npapi-plugindir=${libdir}/mozilla/plugins \
                --enable-mit-shm \
                --disable-cygnal \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                "

PACKAGES =+ " gnash-browser-plugin libgnashamf libgnashbackend libgnashbase libgnashgeo libgnashgui libgnashplayer libgnashserver "

FILES_gnash-browser-plugin= "${libdir}/mozilla/plugins/*"
FILES_libgnashamf = "${libdir}/gnash/libgnashamf-${PV}.so"
FILES_libgnashbackend = "${libdir}/gnash/libgnashbackend-${PV}.so"
FILES_libgnashbase = "${libdir}/gnash/libgnashbase-${PV}.so"
FILES_libgnashgeo = "${libdir}/gnash/libgnashgeo-${PV}.so"
FILES_libgnashgui = "${libdir}/gnash/libgnashgui-${PV}.so"
FILES_libgnashplayer = "${libdir}/gnash/libgnashplayer-${PV}.so"
FILES_libgnashserver = "${libdir}/gnash/libgnashserver-${PV}.so"

PARALLEL_MAKE = ""
