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


SRC_URI[md5sum] = "9d02273f8615b8e3fceda891ffff10d1"
SRC_URI[sha256sum] = "2b349ed73540f8ce68bdfa29e08e3dff9d885027bfa06d6a871a09fe381ddbbe"
