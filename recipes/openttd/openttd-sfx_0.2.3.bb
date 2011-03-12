DESCRIPTION = "Freely licensed sound data files for OpenTTD"
HOMEPAGE = "http://bundles.openttdcoop.org/opensfx/"
LICENSE = "CC Sampling Plus 1.0"

PACKAGE_ARCH = "all"

SRC_URI = "http://bundles.openttdcoop.org/opensfx/releases/opensfx-${PV}.zip"

S = "${WORKDIR}/opensfx-${PV}"

do_install() {
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 *.obs ${D}${datadir}/games/openttd/data/
	install -m 0644 opensfx.cat ${D}${datadir}/games/openttd/data/
	install -m 0644 changelog.txt ${D}${datadir}/games/openttd/data/opensfx_changelog.txt
	install -m 0644 readme.txt ${D}${datadir}/games/openttd/data/opensfx_readme.txt
	install -m 0644 license.txt ${D}${datadir}/games/openttd/data/opensfx_license.txt
}

FILES_${PN} = "${datadir}"

SRC_URI[md5sum] = "3605b82f24153500c8a1804e4420168a"
SRC_URI[sha256sum] = "6831b651b3dc8b494026f7277989a1d757961b67c17b75d3c2e097451f75af02"
