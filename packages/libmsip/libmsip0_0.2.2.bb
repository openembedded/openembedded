LICENSE = "LGPL"

DESCRIPTION = "C++ implementation Session Initiation Protocol (RFC3261)"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libmnetutil0 libmutil0"

inherit autotools

SRC_URI = "http://www.minisip.org/snapshots/libmsip-${PV}.tar.gz"
S="${WORKDIR}/libmsip-${PV}"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libmsip.so.0 ${libdir}/libmsip.so.0.0.0 " 

do_stage() {
	oe_libinstall -a -so libmsip ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/libmsip
	install -m 0644 ${S}/include/libmsip/* ${STAGING_INCDIR}/libmsip
}
