DESCRIPTION = "PyEphem provides scientific-grade astronomical computations \
for the Python programming language."
HOMEPAGE = "http://www.rhodesmill.org/brandon/projects/pyephem.html"
LICENSE = "PSF"
AUTHOR = "Brandon Craig Rhodes"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/p/pyephem/pyephem-${PV}.tar.gz"
S = "${WORKDIR}/pyephem-${PV}"

inherit distutils

SRC_URI[md5sum] = "1e13d951bd46b98476d888bf6e1a06fa"
SRC_URI[sha256sum] = "dd7aedbc9dade0ce25a2a5e2443790fb9d9a607446fb84932e653287b4f160b4"
