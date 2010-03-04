DESCRIPTION = "Jim Clarkes XML parser library."
HOMEPAGE = "http://expat.sf.net/"
SECTION = "libs"
LICENSE = "MIT"

SRC_URI = "${SOURCEFORGE_MIRROR}/expat/expat-${PV}.tar.gz;name=src \
	  "
S = "${WORKDIR}/expat-${PV}"

export LTCC = "${CC}"

inherit autotools

