DESCRIPTION = "Python SOAP Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://pywebsvcs.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS = "python-xml python-fpconst"
SRCNAME = "SOAPpy"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pywebsvcs/${SRCNAME}-${PV}.tar.gz \
           file://fix-future.patch;patch=1 \
           file://fpconst.py"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/fpconst.py ${S}/SOAPpy/fpconst.py
}

SRC_URI[md5sum] = "51ac835366badedd932c64f26fa8336b"
SRC_URI[sha256sum] = "42c8cb3e42b439bc36b6ba3f090ddb72a214ca9264a2babf102c98731dea8e6a"
