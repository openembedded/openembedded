DESCRIPTION = "Python SOAP Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "BSD"
RDEPENDS = "python-core python-xml python-fpconst"
SRCNAME = "SOAPpy"

SRC_URI = "${SOURCEFORGE_MIRROR}/pywebsvcs/${SRCNAME}-${PV}.tar.gz \
           file://fpconst.py"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# *cough*, yes this is a bit hackish.. but for now ;)

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/fpconst.py ${S}/SOAPpy/fpconst.py
}
