PR = "r0"
SRC_URI = "http://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://firefox-cc-fix.patch;patch=1 \
	file://jsautocfg.h \
	file://extensions-hack.patch;patch=1"

S = "${WORKDIR}/mozilla"

inherit mozilla

include firefox.inc
