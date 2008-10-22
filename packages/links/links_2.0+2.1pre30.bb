require links.inc

DEPENDS += "gpm"
RCONFLICTS = "links-x11"
PR = "r1"

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --with-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --without-x --without-sdl"
