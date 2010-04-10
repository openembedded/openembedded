require matchbox-panel.inc
PR ="r5"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
	   file://mb-applet-battery-repaint-093.patch;patch=1 \
	   file://mb-applet-system-monitor-crash.patch;patch=1 \
	   file://matchbox-panel-uninitialised-crash.patch;patch=1"

SRC_URI[md5sum] = "48b58a2e9ada4ae4de6555315ee3506f"
SRC_URI[sha256sum] = "1ec04f3660fecc9c47afd75a9197950ecf8ca5d051b428da188f0262ff982500"
