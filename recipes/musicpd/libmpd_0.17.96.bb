DESCRIPTION = "Music Player Daemon (mpd) library"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/libmpd-${PV}.tar.gz"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"



SRC_URI[md5sum] = "dfbe478c4d4e9bf8e450c7349e104e2a"
SRC_URI[sha256sum] = "f7e11c6137a1628d63985799ebcb78577832fca3ca4aeb2fc53d0e667cf699c0"
