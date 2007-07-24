DEPENDS = "python-pyrex-native python-numeric"

inherit distutils

SRC_URI = "${E_CVS};module=e17/proto/python-efl/${PN}"
S = "${WORKDIR}/${PN}"

do_install_append() {
	rm ${D}${libdir}/${PYTHON_DIR}/site-packages/site.*
}

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

