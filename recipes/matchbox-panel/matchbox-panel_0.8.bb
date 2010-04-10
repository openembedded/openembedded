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

SRC_URI[md5sum] = "053df6ffb53a80d0f06c6ea683f830cd"
SRC_URI[sha256sum] = "e064cf0ab966d14212a4490f341aad574713282e54dc0ec9813a99c3cc2bc453"
