DESCRIPTION = "Python library for Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org/py-libmpdclient.shtml"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libmpd python"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/py-libmpdclient-${PV}.tar.gz"

inherit distutils

SRC_URI[md5sum] = "3a26540b7e057f23187b56e85dc82f95"
SRC_URI[sha256sum] = "fad4e6ca8e9e2a9e4bcddc96194db69827164f65b8a35cb326d0c8cd3a870238"
