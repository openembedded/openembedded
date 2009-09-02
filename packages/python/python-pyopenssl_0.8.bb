DESCRIPTION = "Simple Python wrapper around the OpenSSL library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pyOpenSSL"
DEPENDS = "openssl"
RDEPENDS = "python-threading"
RDEPENDS_${PN}-tests = "${PN}"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyopenssl/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# Exclude debug files from the main packages
FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/*egg-info \
	${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/*.so \
"

FILES_${PN}-dbg += " \
	${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/.debug \
"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests += " \
	${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/test \
"
