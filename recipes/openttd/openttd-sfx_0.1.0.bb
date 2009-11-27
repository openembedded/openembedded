DESCRIPTION = "Sound files for openttd"
HOMEPAGE = "http://bundles.openttdcoop.org/opensfx/"
LICENSE = "CC Sampling Plus 1.0"

PACKAGE_ARCH = "all"

SRC_URI = "http://bundles.openttdcoop.org/download.php?file=opensfx%2Freleases%2Fopensfx-${PV}.zip"

do_install() {
	mv ${WORKDIR}/license.txt ${WORKDIR}/sfx_license.txt
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/opensfx-${PV}.tar ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/sfx_license.txt ${D}${datadir}/games/openttd/data/
}

FILES_${PN} = "${datadir}"
