DESCRIPTION = "Acceleration code for PyOpenGL"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "python-pyopengl"
LICENSE = "BSD"
SRCNAME = "PyOpenGL-accelerate"

SRC_URI = "\
  http://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "4014cd203dd5f52109a76edc4c14a480"
SRC_URI[sha256sum] = "51bc771fd2fc9fc0acec5caf4dc3bd0739127eec4addc04baca545f8c3fe17cd"
