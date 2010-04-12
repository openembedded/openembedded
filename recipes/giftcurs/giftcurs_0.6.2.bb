SECTION = "console/network"
DEPENDS = "ncurses glib-2.0"
RDEPENDS = "gift"
LICENSE = "GPL"
DESCRIPTION = "giFTcurs is a cursed frontend to the giFT daemon and \
has been described as 'seriously slick'. It wont work that well \
without giFT, which you should have already."

SRC_URI = "http://fnord.csbnet.se/giftcurs/giFTcurs-${PV}.tar.gz \
	   file://m4.patch;patch=1"
S = "${WORKDIR}/giFTcurs-${PV}"

inherit autotools

SRC_URI[md5sum] = "9a34b924ea10ce0a1d62441ee2bacfff"
SRC_URI[sha256sum] = "80db72ac16463ce084e76dc9aaae5b54ce8db085610c98fe2975c5b8f51a598d"
