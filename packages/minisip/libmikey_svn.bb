DESCRIPTION = "C++ implementation of the Multimedia Internet KEYing (RFC3830)"
HOMEPAGE = "http://www.minisip.org"
SECTION = "libs/network"
PRIORITY = "optional"
DEPENDS = "libmutil0 openssl"
PV = "0.3.2+svn${SRCDATE}"
LICENSE = "LGPL"

inherit autotools

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=libmikey"
S = "${WORKDIR}/libmikey"

do_stage() {
	autotools_stage_all
}

