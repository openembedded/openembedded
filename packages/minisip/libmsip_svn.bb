DESCRIPTION = "C++ implementation Session Initiation Protocol (RFC3261)"
HOMEPAGE = "http://www.minisip.org"
SECTION = "libs/network"
PRIORITY = "optional"
DEPENDS = "libmnetutil0 libmutil0"
PV = "0.2.2+svn${SRCDATE}"
LICENSE = "LGPL"

inherit autotools

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=libmsip"
S = "${WORKDIR}/libmsip"

do_stage() {
	autotools_stage_all
}
