DESCRIPTION = "Explicitly typed attributes for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "ml0"

inherit setuptools

SRC_URI = "\
  http://pypi.python.org/packages/source/T/Traits/Traits-${PV}.tar.gz \
#  file://fix-import-pyface.diff;patch=1 \
"
S = "${WORKDIR}/Traits-${PV}"

RDEPENDS = "python-netclient"

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/enthought/traits/.debug"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/enthought/traits/protocols/.debug"

SRC_URI[md5sum] = "3b893056fadf3f0781b05b11413162ad"
SRC_URI[sha256sum] = "77224e8464c01162b3afa54d8cec8304ba647fca26f037d454cb6a14e2757604"
