SECTION = "x11/utils"
PR = "r4"
DESCRIPTION = "Matchbox panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox libx11 libxext libxpm apmd startup-notification virtual/kernel"

SRC_URI = "ftp://ftp.handhelds.org/matchbox/sources/matchbox-panel/0.8/matchbox-panel-${PV}.tar.bz2 \
	file://automake-lossage.patch;patch=1 \
	file://more-automake-lossage.patch;patch=1 \
	file://make-batteryapp-less-strict.patch;patch=1"
S = "${WORKDIR}/matchbox-panel-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify --enable-small-icons"

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"
