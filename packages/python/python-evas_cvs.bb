require python-efl.inc

DEPENDS += "evas"

do_stage() {
	distutils_stage_headers
}

#do_stage_append() {
#	install -d ${STAGING_DIR}/${BUILD_SYS}/include/${PYTHON_DIR}/python-evas/
#	install -m 0644 evas/evas.c_evas.pxd ${STAGING_DIR}/${BUILD_SYS}/include/${PYTHON_DIR}/python-evas/
#}

