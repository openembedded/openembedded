DESCRIPTION = "Explicitly typed attributes for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "as0"

SRC_URI = "http://pypi.python.org/packages/source/T/Traits/Traits-3.0.2.tar.gz \
           file://fix-import-pyface.diff;patch=1 \
          "

S = "${WORKDIR}/Traits-${PV}"

RDEPENDS = "python-netclient"

inherit setuptools

FILES_${PN}-dbg += "/usr/lib/python2.5/site-packages/enthought/traits/.debug"
FILES_${PN}-dbg += "/usr/lib/python2.5/site-packages/enthought/traits/protocols/.debug"
