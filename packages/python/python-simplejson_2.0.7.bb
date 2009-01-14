DESCRIPTION = "Simple, fast, extensible JSON encoder/decoder for Python"
HOMEPAGE = "http://cheeseshop.python.org/pypi/simplejson"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "simplejson"
PR = "ml0"

SRC_URI = "http://cheeseshop.python.org/packages/source/s/simplejson/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS = "\
  python-core \
  python-re \
  python-io \
  python-netserver \
"

