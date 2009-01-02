DESCRIPTION = "text processing system"
SECTION = "devel/python"
PR = "0"

SRC_URI = "${SOURCEFORGE_MIRROR}/docutils/docutils-${PV}.tar.gz"

S = "${WORKDIR}/docutils-${PV}"

inherit distutils
