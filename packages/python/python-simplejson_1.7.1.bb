DESCRIPTION = "Simple, fast, extensible JSON encoder/decoder for Python"
HOMEPAGE = "http://cheeseshop.python.org/pypi/simplejson"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "python-setuptools"
# python-netserver is needed for cgi stuff
# python-zlib is needed to unpack egg created by setuptools
RDEPENDS = "python-core python-re python-io python-netserver python-zlib"
SRCNAME = "simplejson"
PR = "r1"

SRC_URI = "http://cheeseshop.python.org/packages/source/s/simplejson/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
