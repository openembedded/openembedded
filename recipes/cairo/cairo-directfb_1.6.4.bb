require cairo.inc
RCONFLICTS = "cairo"
RPROVIDES = "cairo-directfb"
DEPENDS = "directfb pixman libsm libpng fontconfig"
SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
           file://configure_fix.patch;patch=1 "

EXTRA_OECONF += " --enable-directfb \
		  --disable-xlib \
		  --disable-win32"

LDFLAGS_append += " -ldirectfb"
CFLAGS_append  += " -I${STAGING_INCDIR}/directfb"

PR = "r0"

S = "${WORKDIR}/cairo-${PV}"
