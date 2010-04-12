SECTION = "libs"
SRC_URI = "http://handhelds.org/packages/libosip/libosip-0.9.7-hh2.tar.gz"
DESCRIPTION = "Session Initiation Protocol (SIP) library"
LEAD_SONAME = "libosip\..*"
PR = "hh2r0"
LICENSE = "LGPL"
S = "${WORKDIR}/libosip-0.9.7-hh2"

inherit autotools pkgconfig

do_configure_prepend() {
	rm -f acinclude.m4
}

HEADERS = "const.h fifo.h list.h osip.h sdp.h sema.h smsgtypes.h urls.h \
	dialog.h global.h md5.h port.h sdp_negoc.h smsg.h thread.h"

do_stage() {
	oe_libinstall -C fsm -so -a libfsmtl ${STAGING_LIBDIR}
	oe_libinstall -C parser -so -a libosip ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/osip/
	for i in ${HEADERS}; do
		install osip/$i ${STAGING_INCDIR}/osip/$i
	done
}

SRC_URI[md5sum] = "ffc20af80f77653ab534d2a103a2276d"
SRC_URI[sha256sum] = "b67c0218b7cd2d521783bf055b13c598bd04b623cbf4adbb3cc76bd3ac57dc5d"
