inherit python-dir

EXTRA_OEMAKE = ""

export STAGING_INCDIR
export STAGING_LIBDIR

PACKAGES = "${PN}-dev ${PN}-dbg ${PN}-doc ${PN}"

FILES_${PN} = "${bindir}/* ${libdir}/* ${libdir}/${PYTHON_DIR}/*"

FILES_${PN}-dev += "\
  ${datadir}/pkgconfig \
  ${libdir}/pkgconfig \
  ${libdir}/${PYTHON_DIR}/site-packages/*.la \
"
FILES_${PN}-dbg += "\
  ${libdir}/${PYTHON_DIR}/site-packages/.debug \
  ${libdir}/${PYTHON_DIR}/site-packages/*/.debug \
  ${libdir}/${PYTHON_DIR}/site-packages/*/*/.debug \
"
