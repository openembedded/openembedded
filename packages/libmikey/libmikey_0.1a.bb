LICENSE = GPL
DESCRIPTION = "libmikey is a C++ library that implements the IETF work-in-progress MIKEY protocol."
HOMEPAGE = "http://minisip.org/libmikey"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "openssl"

SRC_URI = "http://minisip.org/source/libmikey-${PV}.tar.gz"
S = "${WORKDIR}/libmikey-0.1"

inherit autotools 

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_libinstall -so libmikey ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmikey
	install -m 0644 include/libmikey/*.h ${STAGING_INCDIR}/libmikey/
}
