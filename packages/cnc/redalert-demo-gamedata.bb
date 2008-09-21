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

