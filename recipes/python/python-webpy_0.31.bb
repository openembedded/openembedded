DESCRIPTION = "A Lightweight Web Application Framework"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
PR = "ml0"

SRC_URI = "http://webpy.org/static/web.py-${PV}.tar.gz"
S = "${WORKDIR}/webpy"

inherit distutils

RDEPENDS = "\
  python-netserver \
  python-netclient \
  python-pprint \
"

