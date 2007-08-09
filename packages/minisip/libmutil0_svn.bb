DESCRIPTION = "Class library implementing utilities for C++ programming"
HOMEPAGE = "http://www.minisip.org"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "openssl"
PV = "0.3.1+svn${SRCDATE}"

inherit autotools lib_package

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=libmutil"
S = "${WORKDIR}/libmutil"

do_stage() {
	autotools_stage_all
}
