DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox x11 xext xpm apmd startup-notification virtual/kernel"
SECTION = "x11/wm"
PR = "r1"

SRC_URI = "ftp://ftp.handhelds.org/matchbox/sources/matchbox-panel/0.8/matchbox-panel-${PV}.tar.bz2 \
	file://make-batteryapp-less-strict.patch;patch=1 \
	file://wifi-location.patch;patch=1"
S = "${WORKDIR}/matchbox-panel-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify --enable-small-icons"

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

