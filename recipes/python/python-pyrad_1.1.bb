DESCRIPTION = "Python Radius Client and Server"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS = "python-crypt"
SRCNAME = "pyrad"
PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

SRC_URI[md5sum] = "ab1502f8ccd7409ced757d78b0dee7df"
SRC_URI[sha256sum] = "6a28096ae45261479048a0418b76ad5b6e370031ba8c773f495d8a2b018fc474"
