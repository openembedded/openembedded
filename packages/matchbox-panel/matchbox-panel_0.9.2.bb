include matchbox-panel.inc

PR="r6"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://add_hostap.patch;patch=1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-polling.patch;patch=1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-msgcancel.patch;patch=1 \
           file://kernel2.6.patch;patch=1"


