DESCRIPTION = "Python library for Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org/py-libmpdclient.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "lib/multimedia"
DEPENDS = "libmpd python"
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/py-libmpdclient-${PV}.tar.gz"

inherit distutils
