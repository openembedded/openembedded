SECTION = "games"
DESCRIPTION = "The Freedoom project aims at collaboratively creating a Free IWAD file.\
	       Combined with the Free source code, this results in a complete game \
	       based on the Doom engine which is Free Software."
HOMEPAGE = "http://freedoom.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPL"
do_unpack[depends] += "unzip-native:do_populate_staging"

SRC_URI = "http://ovh.dl.sourceforge.net/sourceforge/freedoom/freedoom-iwad-0.3.zip"

PR = "r1"

FILES_${PN} = "/usr/share/games/doom/*"
FILES_${PN}-doc = "/usr/share/doc/freedoom/*"

do_install() {
	install -d ${D}/usr/share/games/doom
	install -d ${D}/usr/share/doc/freedoom

	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/doom2.wad ${D}/usr/share/games/doom/
	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/* ${D}/usr/share/doc/freedoom
	rm ${D}/usr/share/doc/freedoom/*.wad




}


SRC_URI[md5sum] = "9a26ec9743e45915e296e3e3ba9fe489"
SRC_URI[sha256sum] = "cd563cdceae558e2b9f9a2239b9d7d48a9776125c9d5f5f5be3076d574747aee"
