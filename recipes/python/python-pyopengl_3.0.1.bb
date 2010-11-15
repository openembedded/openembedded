DESCRIPTION = "Standard OpenGL bindings for Python"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "python-numeric"
LICENSE = "BSD"
SRCNAME = "PyOpenGL"

SRC_URI = "\
  http://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "cdf03284f24279b8d9914bb680a37b5e"
SRC_URI[sha256sum] = "79065ba0fec47e9e9514f3be543866f07d7b08071336d566fbf3ab138c442635"
