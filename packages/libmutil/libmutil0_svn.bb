PV = "0.2.2svn${CVSDATE}"
LICENSE = LGPL

DESCRIPTION = "Class library implementing utilities for C++ programming"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "openssl"
DEFAULT_PREFERENCE=-1

inherit autotools

SRC_URI = "svn://svn.minisip.org/var/svn/minisip/trunk;module=libmutil"
S="${WORKDIR}/libmutil"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libmutil.so.0 ${libdir}/libmutil.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmutil ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmutil
	install -m 0644 ${S}/include/libmutil/* ${STAGING_INCDIR}/libmutil
}
