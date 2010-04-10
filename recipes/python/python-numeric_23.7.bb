DESCRIPTION = "A sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/Numeric-${PV}.tar.gz \
           file://no-lapack.patch;patch=1"
S = "${WORKDIR}/Numeric-${PV}"

inherit distutils

do_stage() {
	cp -pPR Include/Numeric ${STAGING_INCDIR}
}


SRC_URI[md5sum] = "8054781c58ae9cf6fe498316860b5ea8"
SRC_URI[sha256sum] = "33225097777e84dfed251aee1265a9c0dd0976854e83f60e778a670027b12e7c"
