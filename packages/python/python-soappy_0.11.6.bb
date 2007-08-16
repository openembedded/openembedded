DESCRIPTION = "Python SOAP Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://pywebsvcs.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS = "python-xml python-fpconst"
SRCNAME = "SOAPpy"

SRC_URI = "${SOURCEFORGE_MIRROR}/pywebsvcs/${SRCNAME}-${PV}.tar.gz \
           file://fix-future.patch;patch=1 \
           file://fpconst.py"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/fpconst.py ${S}/SOAPpy/fpconst.py
}
