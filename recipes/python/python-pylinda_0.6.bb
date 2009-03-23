DESCRIPTION = "Python Implementation of Linda Tuple Space"
SECTION = "devel/python"
HOMEPAGE = "http://www-users.cs.york.ac.uk/~aw/pylinda/"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "linda"
PR = "r1"

SRC_URI = "http://www.handhelds.org/~aquadran/distro/latest/sources/linda-${PV}.tar.gz \
           file://honor-datadir.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export LINDA_DATADIR = "${D}/${libdir}/${PYTHON_DIR}"
