DESCRIPTION = "${PN} bindings"
LICENSE = "BSD"
AUTHOR = "Gustavo Sverzut Barbieri <barbieri@gmail.com>"
HOMEPAGE = "http://www.enlightenment.org"
DEPENDS = "python-cython-native python-numeric"
PV = "0.1.1+cvs${SRCDATE}"

inherit setuptools

SRC_URI = "${E_CVS};module=e17/proto/python-efl/${PN}"
S = "${WORKDIR}/${PN}"

#do_install_append() {
#	rm ${D}${libdir}/${PYTHON_DIR}/site-packages/site.*
#}

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

