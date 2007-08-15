DESCRIPTION = "SourceCode Test Utility"
SECTION = "devel/python"
HOMEPAGE = "http://pychecker.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "pychecker"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
