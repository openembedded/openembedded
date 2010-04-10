DESCRIPTION = "Matchbox Panel Manager"
LICENSE = "GPL"
DEPENDS = "gtk+"
SECTION = "x11/wm"

PR = "r1"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "${bindir}/* ${datadir}/applications ${datadir}/pixmaps"


SRC_URI[md5sum] = "0ea7b03abd7b90eda601b8658a859fb6"
SRC_URI[sha256sum] = "32136aaaf66ff0083158476707f69aa5ee128bc4b3bd62a2be9f9db2dc5804b6"
