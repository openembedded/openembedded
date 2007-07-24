DEPENDS = "python-pyrex-native python-numeric"

inherit distutils

SRC_URI = "${E_CVS};module=e17/proto/python-efl/${PN}"
S = "${WORKDIR}/${PN}"

FILES_${PN}-debug += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

