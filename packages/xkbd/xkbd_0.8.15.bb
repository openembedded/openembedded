SRC_URI = "http://handhelds.org/~mallum/xkbd/xkbd-${PV}-CVS.tar.gz \
           file://libtool-lossage.patch;patch=1;pnum=1 \
	   file://fix-equalsign.patch;patch=1 \
	   file://fix-circumkey.patch;patch=1 \
	   file://xkbd.png"
LICENSE = "GPL"
PR = "r2"

MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "x11"
DEPENDS = "libxpm libxtst libxft"

inherit autotools

do_install_append() {
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/xkbd.png ${D}${datadir}/pixmaps/
}

