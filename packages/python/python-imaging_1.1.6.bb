DESCRIPTION = "Python Imaging Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "freetype jpeg tiff"
RDEPENDS = "python-lang python-stringold"
RDEPENDS_${PN}-doc = "${PN}"
SRCNAME = "Imaging"
PR = "ml2"

SRC_URI = "http://effbot.org/downloads/Imaging-${PV}.tar.gz \
           file://path.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# Exclude debug files from the main packages
FILES_${PN} = " \
	${bindir}/* \
	${libdir}/${PYTHON_DIR}/site-packages/PIL.pth \
	${libdir}/${PYTHON_DIR}/site-packages/PIL/*egg-info \
	${libdir}/${PYTHON_DIR}/site-packages/PIL/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/PIL/*.so \
"

FILES_${PN}-dbg += " \
	${libdir}/${PYTHON_DIR}/site-packages/PIL/.debug \
"

FILES_${PN}-doc += " \
	${docdir}/* \
"

do_compile() {
	export STAGING_LIBDIR=${STAGING_LIBDIR}
  export STAGING_INCDIR=${STAGING_INCDIR}
  distutils_do_compile
}

do_install() {
  export STAGING_LIBDIR=${STAGING_LIBDIR}
  export STAGING_INCDIR=${STAGING_INCDIR}
  distutils_do_install
  install -d ${D}${datadir}/doc/${PN}/html/
  install -m 0644 ${S}/README ${D}${datadir}/doc/${PN}/
  install -m 0644 ${S}/Docs/* ${D}${datadir}/doc/${PN}/html/
}
