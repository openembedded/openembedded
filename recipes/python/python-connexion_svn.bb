DESCRIPTION = "A versatile network connection library"
HOMEPAGE = "http://www.radlinux.org/connexion/"
SECTION = "devel/python"
LICENSE = "GPL"
SRCREV = "1439"
BV = "0.4.6"
PV = "${BV}+svnr${SRCPV}"
PR = "ml1"

inherit distutils

SRC_URI = "svn://radlinux.org/radlinux/branches/${BV};module=lib"
S = "${WORKDIR}/lib"

MODULES = "cxutil cxnet"

do_compile() {
	for i in ${MODULES}; do
		cd ${S}/$i && distutils_do_compile
	done
}

do_install() {
	for i in ${MODULES}; do
		cd ${S}/$i && distutils_do_install
	done
}

RDEPENDS_${PN} += "python-ctypes"

