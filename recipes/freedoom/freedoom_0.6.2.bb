SECTION = "games"
DESCRIPTION = "The Freedoom project aims at collaboratively creating a Free IWAD file.\
	       Combined with the Free source code, this results in a complete game \
	       based on the Doom engine which is Free Software."
HOMEPAGE = "http://freedoom.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPL"
do_unpack[depends] += "unzip-native:do_populate_staging"

SRC_URI = "${SOURCEFORGE_MIRROR}/freedoom/freedoom-iwad-${PV}.zip"

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}/games/doom/*"
FILES_${PN}-doc = "${datadir}/doc/freedoom/*"

do_install() {
	install -d ${D}/${datadir}/games/doom
	install -d ${D}/${datadir}/doc/freedoom

	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/doom2.wad ${D}/${datadir}/games/doom/
	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/* ${D}/${datadir}/doc/freedoom
	rm ${D}/${datadir}/doc/freedoom/*.wad




}


SRC_URI[md5sum] = "832dfd51ac653f7c64fa44dc4badb6bb"
SRC_URI[sha256sum] = "70ee4b5502c65c77a59ac40b3a86a4904d2f78c2edf058503d1c35ae6a75dcd6"
