PV = "0.2.2svn${CVSDATE}"
LICENSE = LGPL

DESCRIPTION = "Networking class library for C++ programming"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"
DEFAULT_PREFERENCE=-1

inherit autotools

SRC_URI = "svn://svn.minisip.org/var/svn/minisip/trunk;module=libmnetutil"
S="${WORKDIR}/libmnetutil"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libmnetutil.so.0 ${libdir}/libmnetutil.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmnetutil ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmnetutil
	install -m 0644 ${S}/include/libmnetutil/* ${STAGING_INCDIR}/libmnetutil
}
