LICENSE = "GPL"
SECTION = "console/network"
DEPENDS = "jpeg libpng flex openssl zlib x11"
DESCRIPTION = "Links is graphics and text mode WWW \
browser, similar to Lynx."
RCONFLICTS = "links"

MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"

SRC_URI = "http://links.twibright.com/download/links-${PV}.tar.bz2 \
           file://ac-prog-cxx.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --without-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --with-x --without-gpm --without-sdl"

S = "${WORKDIR}/links-${PV}"
