DESCRIPTION = "A Pure Python CORBA Package"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "FNORB"
SRCNAME = "Fnorb"

SRC_URI = "${SOURCEFORGE_MIRROR}/fnorb/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

