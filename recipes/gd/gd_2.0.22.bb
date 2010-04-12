SECTION = "libs"
LICENSE = "GD"
DESCRIPTION = "gd is a library used to create PNG, JPEG, or WBMP images."
DEPENDS = "libpng jpeg zlib"
PR = "r1"

SRC_URI = "http://www.boutell.com/gd/http/gd-${PV}.tar.gz"
S = "${WORKDIR}/gd-${PV}"

inherit autotools binconfig gettext

EXTRA_OECONF += " --with-zlib=${STAGING_LIBDIR}/.. \
                  --with-png=${STAGING_LIBDIR}/.. \
                  --with-jpeg=${STAGING_LIBDIR}/.. \
                  --without-xpm"

headers = "gd.h gdcache.h gd_io.h gdfx.h gdfontmb.h \
	   gdfontg.h gdfontl.h gdfonts.h gdfontt.h"

do_stage () {
	oe_libinstall -so -a libgd ${STAGING_LIBDIR}/
	for i in ${headers}; do
		install -m 0644 $i ${STAGING_INCDIR}/
	done
}

SRC_URI[md5sum] = "e1a41daf3bfc221afaf56751dc506f95"
SRC_URI[sha256sum] = "e6bff5c00d7d93bade78535573494673f581118c38a8ca13c3afd63809335ba0"
