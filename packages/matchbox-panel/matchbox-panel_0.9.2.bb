include matchbox-panel.inc

PR="r13"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://add_hostap.patch;patch=1 \
           file://mb-panel-0.9.2-polling.patch;patch=1 \
           file://mb-panel-0.9.2-msgcancel.patch;patch=1 \
           file://mb-applet-battery-repaint.patch;patch=1 \
           file://mb-panel-multi-category-matching.patch;patch=1 \
           file://mb-panel-allow-disabling-menu-panel.patch;patch=1 \
	   file://mb-panel-svn-r1162.diff;patch=1;pnum=0 \
           file://system-monitor-crash-fix.patch;patch=1 "


