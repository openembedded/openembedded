SRC_URI = "http://handhelds.org/~mallum/xkbd/xkbd-${PV}-CVS.tar.gz \
           file://libtool-lossage.patch;patch=1;pnum=1 \
	   file://xkbd.png"
LICENSE = "GPL"

MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "x11"
DEPENDS = "xpm xtst libxft"

inherit autotools

do_install_append() {
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/xkbd.png ${D}${datadir}/pixmaps/
}

