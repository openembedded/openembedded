DESCRIPTION = "Links is graphics and text mode WWW \
browser, similar to Lynx."
HOMEPAGE = "http://links.twibright.com/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "jpeg libpng flex openssl zlib virtual/libx11"
RCONFLICTS = "links"
PR = "r0"
SRC_URI = "http://links.twibright.com/download/links-${PV}.tar.bz2 \
           file://ac-prog-cxx.patch;patch=1 \
           file://cookies-save-0.96.patch;patch=1 \
           file://links-2.1pre17-fix-segfault-on-loading-cookies.patch;patch=1 \
	   file://links2.desktop \
           http://www.xora.org.uk/oe/links2.png"
S = "${WORKDIR}/links-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --without-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --with-x --without-gpm --without-sdl"

do_install_append() {
        install -d ${D}/${datadir}/applications
        install -m 0644 ${WORKDIR}/links2.desktop ${D}/${datadir}/applications
        install -d ${D}/${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/links2.png ${D}/${datadir}/pixmaps
}

