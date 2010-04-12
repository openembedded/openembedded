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

SRC_URI[md5sum] = "5b9db574c9fbb94ce52047600190a1ba"
SRC_URI[sha256sum] = "a3e9b0f07910ee325406118cf3e136fc78a5155c47fdb19e66e895a3c587bc51"
