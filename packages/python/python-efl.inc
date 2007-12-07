DESCRIPTION = "${PN} bindings"
LICENSE = "BSD"
AUTHOR = "Gustavo Sverzut Barbieri <barbieri@gmail.com>"
HOMEPAGE = "http://www.enlightenment.org"
# somewhere is a bug. cython should be self-contained, but somehow this
# does not compile unless pyrex has been built
DEPENDS = "python-cython-native python-pyrex-native python-numeric"
PV = "0.1.1+cvs${SRCDATE}"

inherit setuptools

SRC_URI = "${E_CVS};module=e17/proto/python-efl/${PN}"
S = "${WORKDIR}/${PN}"

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

