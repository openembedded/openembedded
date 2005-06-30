DESCRIPTION = "a unit test framework for C"
LICENSE = "LGPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "devel"

SRC_URI = "${SOURCEFORGE_MIRROR}/check/check-${PV}.tar.gz"
S = "${WORKDIR}/check-${PV}"

inherit autotools

EXTRA_OECONF += "--enable-plain-docdir"
