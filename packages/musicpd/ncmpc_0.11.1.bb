DESCRIPTION = "Ncurses based Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/ncmpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "console/multimedia"
DEPENDS = "ncurses glib-2.0"
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/ncmpc-${PV}.tar.gz"

inherit autotools
