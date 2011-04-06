# cannot use ${PN} because ie fsodeviced has modules in fsodevice
CORNUCOPIA_MODULE_DIR = "${libdir}/cornucopia/modules/*"
FILES_${PN}     += "${CORNUCOPIA_MODULE_DIR}/*.so"
FILES_${PN}-dev += "${CORNUCOPIA_MODULE_DIR}/*.la"
FILES_${PN}-dbg += "${CORNUCOPIA_MODULE_DIR}/.debug"

