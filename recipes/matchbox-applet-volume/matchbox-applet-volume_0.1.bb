DESCRIPTION = "Matchbox Volume Applet"
LICENSE = "GPL"
DEPENDS = "matchbox-wm libmatchbox"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/mb-applet-volume/${PV}/mb-applet-volume-${PV}.tar.gz"
S = "${WORKDIR}/mb-applet-volume-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} ${datadir}/applications ${datadir}/pixmaps"


SRC_URI[md5sum] = "d778eb73932dbaa944680f93b153b2bb"
SRC_URI[sha256sum] = "7c43a4169b4bea9db1e86a9d16609ae62424b1743696d35ba58eb5665eddd26a"
