DESCRIPTION = "A sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/Numeric-${PV}.tar.gz \
           file://no-lapack.patch;patch=1"
S = "${WORKDIR}/Numeric-${PV}"

inherit distutils

do_stage() {
	cp -pPR Include/Numeric ${STAGING_INCDIR}
}

