DESCRIPTION = "Class library implementing utilities for C++ programming"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"

DEPENDS = "openssl"

PV = "0.3.1+svn${SRCDATE}"

inherit autotools lib_package

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=libmutil"
S = "${WORKDIR}/libmutil"

do_stage() {
	oe_libinstall -a -so libmutil ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmutil
	install -m 0644 ${S}/include/libmutil/* ${STAGING_INCDIR}/libmutil
}
