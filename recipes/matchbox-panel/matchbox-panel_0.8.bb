SECTION = "x11/utils"
DESCRIPTION = "Matchbox panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm"
RDEPENDS = "libmatchbox matchbox-common"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-panel/${PV}/matchbox-panel-${PV}.tar.bz2"
S = "${WORKDIR}/matchbox-panel-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-small-icons"
#		--enable-dnotify
#		--enable-startup-notification
