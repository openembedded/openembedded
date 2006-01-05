LICENSE = "GPL"
DESCRIPTION = "The Openobex project aims to make an \
open source implementation of the Object Exchange \
(OBEX) protocol."
SECTION = "libs"
PR = "r4"

# put openobex-config into -dev package
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/openobex-${PV}.tar.gz \
	  file://syms.patch;patch=1"

inherit autotools binconfig

do_stage () {
	oe_libinstall -so -C src libopenobex ${STAGING_LIBDIR}
	ln -sf libopenobex.so ${STAGING_LIBDIR}/libopenobex-1.0.so
	install -d ${STAGING_INCDIR}/openobex
	install -m 0644 src/obex_const.h src/obex.h ${STAGING_INCDIR}/openobex/
	install -d ${STAGING_DIR}/aclocal
	install -m 0644 m4macros/openobex.m4 ${STAGING_DATADIR}/aclocal/
}
