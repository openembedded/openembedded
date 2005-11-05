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
