require matchbox-panel.inc
PR ="r5"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
	   file://mb-applet-battery-repaint-093.patch;patch=1 \
	   file://mb-applet-system-monitor-crash.patch;patch=1 \
	   file://matchbox-panel-uninitialised-crash.patch;patch=1"
