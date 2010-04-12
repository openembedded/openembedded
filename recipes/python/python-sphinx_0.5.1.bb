DESCRIPTION = "Python documentation generator"
SECTION = "devel/python"
LICENSE = "BSD"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/S/Sphinx/Sphinx-${PV}.tar.gz"
S = "${WORKDIR}/Sphinx-${PV}"

inherit distutils

SRC_URI[md5sum] = "11456e362d75c1a4c5a5847921d3f4c7"
SRC_URI[sha256sum] = "871c04e577625520091a2d3ea8ac09469ce2dcf7db9dbd6e54a57264879dac29"
