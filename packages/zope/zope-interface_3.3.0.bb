DESCRIPTION = "zope.interface is provides Zope 3-styled interface definitions \
for python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "ZPL"
SRCNAME = "zope.interface"
PR = "r1"
SRC_URI = "http://www.zope.org/Products/ZopeInterface/${PV}/${SRCNAME}-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

PACKAGES += "\
  ${PN}-dbg \
  ${PN}-test \
  ${PN}-doc \
"

FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/*egg-info \
	${libdir}/${PYTHON_DIR}/site-packages/zope/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/*.so \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/common/*.py* \
"

FILES_${PN}-dbg += " \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/.debug \
"

FILES_${PN}-test = " \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/tests \
"

FILES_${PN}-doc = " \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/*.txt \
"