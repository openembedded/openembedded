LICENSE = "GPL"
SECTION = "console/network"
DEPENDS = "jpeg libpng gpm flex openssl zlib"
DESCRIPTION = "Links is graphics and text mode WWW \
browser, similar to Lynx."

SRC_URI = "http://links.twibright.com/download/links-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --with-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --without-x"
