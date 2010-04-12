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

SRC_URI[md5sum] = "c3e1b6c428218968e2963182c1df1fdc"
SRC_URI[sha256sum] = "cba8ac22d77bbf8f6ed4a98933242b89ee2426cbc216f54415eafcac1274547a"
