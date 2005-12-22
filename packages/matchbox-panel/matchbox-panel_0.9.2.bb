include matchbox-panel.inc

PR="r5"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://add_hostap.patch;patch=1 \
           file://kernel2.6.patch;patch=1"


