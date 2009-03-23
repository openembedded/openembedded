DESCRIPTION = "Music Player Daemon (mpd) library"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/libmpd-${PV}.tar.gz"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"


