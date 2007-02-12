DESCRIPTION = "Python library for Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org/py-libmpdclient.shtml"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libmpd python"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/py-libmpdclient-${PV}.tar.gz"

inherit distutils
