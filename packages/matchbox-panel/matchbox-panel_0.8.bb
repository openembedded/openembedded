SECTION = "x11/utils"
DESCRIPTION = "Matchbox panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox x11 xext xpm"
RDEPENDS = "libmatchbox matchbox-common"

SRC_URI = "ftp://ftp.handhelds.org/matchbox/sources/matchbox-panel/${PV}/matchbox-panel-${PV}.tar.bz2"
S = "${WORKDIR}/matchbox-panel-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-small-icons"
#		--enable-dnotify
#		--enable-startup-notification
