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
