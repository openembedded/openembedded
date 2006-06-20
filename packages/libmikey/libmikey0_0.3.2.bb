DESCRIPTION = "C++ implementation of the Multimedia Internet KEYing (RFC3830)"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"
PR = "r1"

inherit autotools

SRC_URI = "http://www.minisip.org/snapshots/libmikey-${PV}.tar.gz"
S="${WORKDIR}/libmikey-${PV}"

FILES_${PN} = " ${libdir}/libmikey.so.0 ${libdir}/libmikey.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmikey ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmikey
	install -m 0644 ${S}/include/libmikey/* ${STAGING_INCDIR}/libmikey
}
