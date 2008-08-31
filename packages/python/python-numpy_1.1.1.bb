DESCRIPTION = "A sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/numpy-${PV}.tar.gz \
           file://unbreak-assumptions.diff;patch=1 \
	   "

S = "${WORKDIR}/numpy-${PV}"

inherit distutils

do_stage() {
	cp -pPR Include/Num* ${STAGING_INCDIR}
}

