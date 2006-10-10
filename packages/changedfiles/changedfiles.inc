DESCRIPTION = "A framework for simple filesystem replication \
and/or security monitoring and/or automatic file transformations"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fget"
RDEPENDS = "fget"

SRC_URI = "http://www.bangstate.com/changedfiles-${PV}.tar.gz"
S = "${WORKDIR}/changedfiles-${PV}"
