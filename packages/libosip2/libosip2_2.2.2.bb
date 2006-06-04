SECTION = "libs"
DESCRIPTION = "Session Initiation Protocol (SIP) library"
LEAD_SONAME = "libosip2\..*"
PR = "r0"
LICENSE = "LGPL"
SRC_URI = "${GNU_MIRROR}/osip/libosip2-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	oe_libinstall -C src/osip2 -so -a libosip2 ${STAGING_LIBDIR}
	oe_libinstall -C src/osipparser2 -so -a libosipparser2 ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/osip2/
	install -d ${STAGING_INCDIR}/osipparser2/
	install -d ${STAGING_INCDIR}/osipparser2/headers/
	install include/osip2/*.h ${STAGING_INCDIR}/osip2/
	install include/osipparser2/*.h ${STAGING_INCDIR}/osipparser2/
	install include/osipparser2/headers/*.h ${STAGING_INCDIR}/osipparser2/headers/
}
