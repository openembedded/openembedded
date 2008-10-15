DESCRIPTION = "Matchbox input manager"
LICENSE = "GPL"
DEPENDS = "matchbox-wm libmatchbox"
SECTION = "x11/wm"

PR = "r4"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/mb-applet-input-manager/${PV}/mb-applet-input-manager-${PV}.tar.gz \
	   file://update-to-svn.diff;patch=1 \
           file://mbinputmgr-libgtkinput.patch;patch=1 \
	   file://visibility-protocol.patch;patch=1 \
	   "

S = "${WORKDIR}/mb-applet-input-manager-${PV}"


inherit autotools pkgconfig

FILES_${PN} = "${bindir}/* ${datadir}/applications ${datadir}/pixmaps"

