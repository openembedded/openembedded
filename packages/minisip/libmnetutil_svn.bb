DESCRIPTION = "Networking class library for C++ programming"
HOMEPAGE = "http://www.minisip.org"
SECTION = "libs/network"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"
PV = "0.2.2+svn${SRCDATE}"
LICENSE = "LGPL"

inherit autotools

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=libmnetutil"
S = "${WORKDIR}/libmnetutil"

do_stage() {
	autotools_stage_all
}
