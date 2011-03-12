DESCRIPTION = "Freely licensed graphics data files for OpenTTD"
HOMEPAGE = "http://bundles.openttdcoop.org"
LICENSE = "GPLv2"

PACKAGE_ARCH = "all"

SRC_URI = "http://bundles.openttdcoop.org/opengfx/releases/${PV}/opengfx-${PV}.zip"

S = "${WORKDIR}/opengfx-${PV}"

do_install() {
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${S}/*.grf ${D}${datadir}/games/openttd/data/
	install -m 0644 ${S}/*.obg ${D}${datadir}/games/openttd/data/
	install -m 0644 ${S}/changelog.txt ${D}${datadir}/games/openttd/data/opengfx_changelog.txt
	install -m 0644 ${S}/readme.txt ${D}${datadir}/games/openttd/data/opengfx_readme.txt
	install -m 0644 ${S}/license.txt ${D}${datadir}/games/openttd/data/opengfx_license.txt
}

FILES_${PN} = "${datadir}"

SRC_URI[md5sum] = "70a09cf9df7938a3c3f184d18fc4f0f1"
SRC_URI[sha256sum] = "e9f94bb0799e9a8d9bf6451da353434086f027fe0dfb7c01d205f739467fafdb"
