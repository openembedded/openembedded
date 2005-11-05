DESCRIPTION = "A Software Construction Tool"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "scons"

SRC_URI = "${SOURCEFORGE_MIRROR}/scons/scons-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
