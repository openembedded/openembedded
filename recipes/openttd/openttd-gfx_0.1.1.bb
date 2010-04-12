DESCRIPTION = "Grafik files for openttd"
HOMEPAGE = "http://bundles.openttdcoop.org/opengfx/"
LICENSE = "GPLv2"

PACKAGE_ARCH = "all"

SRC_URI = "http://bundles.openttdcoop.org/download.php?file=opengfx%2Freleases%2Fopengfx-${PV}.zip"

do_install() {
	mv ${WORKDIR}/docs/license.txt ${WORKDIR}/gfx_license.txt
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/opengfx-${PV}.tar ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/gfx_license.txt ${D}${datadir}/games/openttd/data/
}

FILES_${PN} = "${datadir}"

SRC_URI[md5sum] = "1f959407f2d4a1ab0e84c2e89438c922"
SRC_URI[sha256sum] = "c0eefb2dda166f91e1bfb317cf681165029f6f2709fa966d84dc568ffef6a31e"
