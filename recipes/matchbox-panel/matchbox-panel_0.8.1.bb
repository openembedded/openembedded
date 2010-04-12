SECTION = "x11/utils"
PR = "r4"
DESCRIPTION = "Matchbox panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm apmd startup-notification virtual/kernel"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-panel/0.8/matchbox-panel-${PV}.tar.bz2 \
	file://automake-lossage.patch;patch=1 \
	file://more-automake-lossage.patch;patch=1 \
	file://make-batteryapp-less-strict.patch;patch=1"
S = "${WORKDIR}/matchbox-panel-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify --enable-small-icons"

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

SRC_URI[md5sum] = "cfdfb6b006af834513be839d128a4cd7"
SRC_URI[sha256sum] = "771608e1e2baa2e16781024faa93b24a38556d383158883deff78f7093017534"
