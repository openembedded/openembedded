DESCRIPTION = "Links is graphics and text mode WWW \
browser, similar to Lynx."
HOMEPAGE = "http://links.twibright.com/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "jpeg libpng gpm flex openssl zlib"
RCONFLICTS="links-x11"
PR = "r0"
SRC_URI = "http://links.twibright.com/download/links-${PV}.tar.bz2 \
           file://ac-prog-cxx.patch;patch=1 \
           file://cookies-save-0.96.patch;patch=1 \
           file://links-2.1pre17-fix-segfault-on-loading-cookies.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --with-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --without-x --without-sdl"
