DESCRIPTION = "Next Generation sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PYRAF"
SRCNAME = "numarray"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/numarray/examples/*/.debug"

SRC_URI[md5sum] = "40cec6ce8ca2e95a4fbc7a28879bf4a5"
SRC_URI[sha256sum] = "7a6f7f2745cbcb02bf79cc7cd365a3f80679f2558dfaa378010675f40a7aff3b"
