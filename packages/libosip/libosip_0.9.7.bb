SECTION = "libs"
SRC_URI = "http://handhelds.org/pub/linux/packages/libosip/libosip-0.9.7-hh2.tar.gz"
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
