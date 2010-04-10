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


SRC_URI[md5sum] = "439b0700f9f5d422e5db6f28c0f86b11"
SRC_URI[sha256sum] = "01f30f86c9ea41e7fcc9bc4cabb17283de7dbf19c301254161a89dd0a73cb9f3"
