inherit python-dir

EXTRA_OEMAKE = ""

export STAGING_INCDIR
export STAGING_LIBDIR
# libtool 2.4 does not export with LDFLAGS but distutils need it
LDFLAGS_prepend = "-L${STAGING_LIBDIR} "

PACKAGES = "${PN}-dev ${PN}-dbg ${PN}-doc ${PN}"

FILES_${PN} = "${bindir}/* ${libdir}/* ${libdir}/${PYTHON_DIR}/*"

FILES_${PN}-dev += "\
  ${datadir}/pkgconfig \
  ${libdir}/pkgconfig \
  ${PYTHON_SITEPACKAGES_DIR}/*.la \
"
FILES_${PN}-dbg += "\
  ${PYTHON_SITEPACKAGES_DIR}/.debug \
  ${PYTHON_SITEPACKAGES_DIR}/*/.debug \
  ${PYTHON_SITEPACKAGES_DIR}/*/*/.debug \
"
