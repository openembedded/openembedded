require cairo.inc
RCONFLICTS = "cairo"
RPROVIDES = "cairo-directfb"
DEPENDS = "directfb libsm libpng fontconfig"
SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
	   file://cairo_directfb_is_similar-typo.patch;patch=1 \
	  "

EXTRA_OECONF += " --enable-directfb \
		  --disable-xlib \
		  --disable-win32"

LDFLAGS_append += " -ldirectfb"
CFLAGS_append  += " -I${STAGING_INCDIR}/directfb"

PR = "r2"

S = "${WORKDIR}/cairo-${PV}"
