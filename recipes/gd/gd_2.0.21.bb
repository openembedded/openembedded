SECTION = "libs"
LICENSE = "GD"
DESCRIPTION = "gd is a library used to create PNG, JPEG, or WBMP images."
DEPENDS = "libpng jpeg zlib"

SRC_URI = "http://www.boutell.com/gd/http/gd-${PV}.tar.gz"
S = "${WORKDIR}/gd-${PV}"

inherit autotools gettext

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

SRC_URI[md5sum] = "3134158635f5048dba99281c6b712a54"
SRC_URI[sha256sum] = "c3b8b7b57019927dad40870c379eecfa6389443f7e2096aa0157a0224d400da1"
