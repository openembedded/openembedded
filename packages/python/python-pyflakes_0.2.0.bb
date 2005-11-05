DESCRIPTION = "SourceCode Test Utility"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "BSD"
SRCNAME = "pyflakes"

SRC_URI = "http://www.divmod.org/static/projects/pyflakes/pyflakes-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
