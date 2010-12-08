DESCRIPTION = "Music Player Daemon (mpd) library"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/libmpd-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "2f1c99e12c69f7d95cfd1e27368056ed"
SRC_URI[sha256sum] = "7205b01b007b2ef06f19aacca26fec2673b730f1a9b6c2ce0ed6728c9ac67723"

