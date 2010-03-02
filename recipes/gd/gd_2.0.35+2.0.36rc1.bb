SECTION = "libs"
LICENSE = "GD"
DESCRIPTION = "gd is a library used to create PNG, JPEG, or WBMP images."
DEPENDS = "libpng jpeg zlib"
PR = "r2"

SRC_URI = "http://www.libgd.org/releases/gd-2.0.36RC1.tar.gz;name=src"
SRC_URI[src.md5sum] = "39ac48e6d5e0012a3bd2248a0102f209"
SRC_URI[src.sha256sum] = "dd7c1795271221b9237769b96b8cec7fbdc5db7b8954d864ead51fc1296a6ac8"

S = "${WORKDIR}/gd-2.0.36RC1"

inherit autotools binconfig gettext

EXTRA_OECONF += " --with-zlib=${STAGING_LIBDIR}/.. \
                  --with-png=${STAGING_LIBDIR}/.. \
                  --with-jpeg=${STAGING_LIBDIR}/.. \
                  --without-freetype \
                  --without-fontconfig \
                  --without-xpm \
                  --without-x"

EXTRA_OEMAKE = 'LDFLAGS="${LDFLAGS}"'

headers = "gd.h gdcache.h gd_io.h gdfx.h gdfontmb.h \
	   gdfontg.h gdfontl.h gdfonts.h gdfontt.h"

do_stage () {
	oe_libinstall -so -a libgd ${STAGING_LIBDIR}/
	for i in ${headers}; do
		install -m 0644 $i ${STAGING_INCDIR}/
	done
}
