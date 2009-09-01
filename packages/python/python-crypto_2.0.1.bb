DESCRIPTION = "A collection of cryptographic algorithms and protocols"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "gmp"
SRCNAME = "pycrypto"
LICENSE = "python-crypto"
RDEPENDS_${PN}-tests = "${PN}"
PR = "r1"

SRC_URI = "http://www.amk.ca/files/python/crypto/${SRCNAME}-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# Exclude debug files from the main packages
FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/*egg-info \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/*/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/*/*.so \
"

FILES_${PN}-dbg += " \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/*/.debug \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/*/*/.debug \
"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests += " \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/test.py* \
	${libdir}/${PYTHON_DIR}/site-packages/Crypto/Util/test.py* \
"

