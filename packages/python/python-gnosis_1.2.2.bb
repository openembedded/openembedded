DESCRIPTION = "Gnosis Utils contains several Python modules for XML processing, plus other generally useful tools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "Gnosis_Utils"
PR = "ml0"

SRC_URI = "http://gnosis.cx/download/Gnosis_Utils.More/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

