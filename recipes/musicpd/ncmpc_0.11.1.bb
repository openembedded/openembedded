DESCRIPTION = "Ncurses based Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/ncmpc.shtml"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "ncurses glib-2.0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/ncmpc-${PV}.tar.gz"

inherit autotools
