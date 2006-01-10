PV = "0.3.2+svn${SRCDATE}"
LICENSE = "LGPL"

DESCRIPTION = "C++ implementation of the Multimedia Internet KEYing (RFC3830)"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"
DEFAULT_PREFERENCE=-1


inherit autotools

SRC_URI = "svn://svn.minisip.org/var/svn/minisip/trunk;module=libmikey"
S="${WORKDIR}/libmikey"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libmikey.so.0 ${libdir}/libmikey.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmikey ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmikey
	install -m 0644 ${S}/include/libmikey/* ${STAGING_INCDIR}/libmikey
}
