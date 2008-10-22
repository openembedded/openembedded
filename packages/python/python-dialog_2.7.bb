DESCRIPTION = "Dialog-like functionality for Python Console Programs"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pythondialog"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
