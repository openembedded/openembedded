DESCRIPTION = "Python Implementation of Linda Tuple Space"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
SRCNAME = "linda"

SRC_URI = "http://www-users.cs.york.ac.uk/~aw/pylinda/dist/linda-${PV}.tar.gz \
           file://honor-datadir.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export LINDA_DATADIR = "${D}/${libdir}/${PYTHON_DIR}"
