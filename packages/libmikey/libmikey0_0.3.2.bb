LICENSE = "LGPL"

DESCRIPTION = "C++ implementation of the Multimedia Internet KEYing (RFC3830)"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"

inherit autotools

SRC_URI = "http://www.minisip.org/snapshots/libmikey-${PV}.tar.gz"
S="${WORKDIR}/libmikey-${PV}"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libmikey.so.0 ${libdir}/libmikey.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmikey ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmikey
	install -m 0644 ${S}/include/libmikey/* ${STAGING_INCDIR}/libmikey
}
