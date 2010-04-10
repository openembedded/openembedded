DESCRIPTION = "Matchbox input manager"
LICENSE = "GPL"
DEPENDS = "matchbox-wm libmatchbox"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/mb-applet-input-manager/${PV}/mb-applet-input-manager-${PV}.tar.bz2"
S = "${WORKDIR}/mb-applet-input-manager-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} ${datadir}/applications ${datadir}/pixmaps"


SRC_URI[md5sum] = "bf36926ac97d0419a141f9d18ffab103"
SRC_URI[sha256sum] = "7a1298ea42a976e7a133ec160400daee055450872dcc40d671f08376fc08850a"
