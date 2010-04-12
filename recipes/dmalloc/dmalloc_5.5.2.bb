DESCRIPTION = "Debug Malloc Library"
SECTION = "libs/devel"
HOMEPAGE = "http://dmalloc.com"
LICENSE = "CCSA"

SRC_URI = "\
  http://dmalloc.com/releases/dmalloc-${PV}.tgz \
  file://configure-pagesize-HACK.patch;patch=1 \
# HACK we ship a preconfigured conf.h since otherwise it misses a whole lot of stuff and compilation fails.
# TODO find out why and get rid of it
  file://conf.h \
"
inherit autotools pkgconfig

do_configure_append() {
	install -m 0644 ${WORKDIR}/conf.h ${S}
}

do_stage() {
	oe_libinstall -a libdmalloc ${STAGING_LIBDIR}
}

do_install() {
	:
}

SRC_URI[md5sum] = "f92e5606c23a8092f3d5694e8d1c932e"
SRC_URI[sha256sum] = "d3be5c6eec24950cb3bd67dbfbcdf036f1278fae5fd78655ef8cdf9e911e428a"
