DESCRIPTION = "Red Alert Demo game data"
LICENSE = "shareware"

SRC_URI = "ftp://ftp.westwood.com/pub/redalert/previews/demo/ra95demo.zip"

do_install() {
	install -d ${D}/${datadir}/games/redalert/data/mix
	cp ${WORKDIR}/ra95demo/INSTALL/MAIN.MIX ${D}/${datadir}/games/redalert/data/mix/main.mix
	cp ${WORKDIR}/ra95demo/INSTALL/REDALERT.MIX ${D}/${datadir}/games/redalert/data/mix/redalert.mix
}


PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/games/redalert/"


SRC_URI[md5sum] = "b44ab9ec1bc634ea755587d1988e3722"
SRC_URI[sha256sum] = "8c48bdb53523ea4d353a7914d9234ce4e3e6f5832eeb47b3b6b005853e8748d2"
