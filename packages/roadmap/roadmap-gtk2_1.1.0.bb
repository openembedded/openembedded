require roadmap-gtk2.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/roadmap/roadmap-${PV}-src.tar.gz \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://roadmap.desktop.patch;patch=1 \
	   http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz "

S = "${WORKDIR}/roadmap-${PV}/src"
