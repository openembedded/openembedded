include matchbox-panel.inc

PR="r12"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://add_hostap.patch;patch=1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-polling.patch;patch=1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-msgcancel.patch;patch=1 \
           file://mb-applet-battery-repaint.patch;patch=1 \
           file://mb-panel-multi-category-matching.patch;patch=1 \
           file://mb-panel-allow-disabling-menu-panel.patch;patch=1 \
	   file://system-monitor-crash-fix.patch;patch=1 "


