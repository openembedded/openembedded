DESCRIPTION = "A PyQt-optimized Python Quicklauncher for Qt/Embedded based Palmtop Environments"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RDEPENDS = "python-pyqt"
PR = "ml1"
SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/tools/pyquicklauncher"
S = "${WORKDIR}/pyquicklauncher"
LICENSE = "GPL"
inherit distutils

do_compile() {
	true
}

#
# FIXME: Launch during postinstall
#

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}/
	install -m 0755 quicklauncher.py ${D}${libdir}/${PYTHON_DIR}/
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/quicklauncher/
	install -m 0755 testapp.py ${D}${libdir}/${PYTHON_DIR}/site-packages/quicklauncher/
}
 

