LICENSE = "GPL"
DESCRIPTION = "Transparent xcursor theme for handheld systems with visible watch cursor"
SECTION = "x11/base"
PR="r1"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/utils/xcursor-transparent-theme-${PV}.tar.gz \
	   file://use-relative-symlinks.patch;patch=1 \
	   file://skip_watch_cursor.patch;patch=1"
S = "${WORKDIR}/xcursor-transparent-theme-${PV}"

FILES_${PN} = "${datadir}/icons/xcursor-transparent/cursors/*"

inherit autotools
