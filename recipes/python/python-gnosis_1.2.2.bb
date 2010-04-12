DESCRIPTION = "Gnosis Utils contains several Python modules for XML processing, plus other generally useful tools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "Gnosis_Utils"
PR = "ml1"

SRC_URI = "http://gnosis.cx/download/Gnosis_Utils.More/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils


SRC_URI[md5sum] = "729984e5858fa626359a8d6447a24bae"
SRC_URI[sha256sum] = "5673927f18790511f2a01004a51110e167f7950e7accf9e1bc6832a4bfed4feb"
