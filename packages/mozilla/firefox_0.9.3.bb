PR = "r2"
SRC_URI = "http://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://extensions-hack.patch;patch=1 \
	file://mozilla-firefox.png file://mozilla-firefox.desktop"
S = "${WORKDIR}/mozilla"

inherit mozilla

include firefox.inc
