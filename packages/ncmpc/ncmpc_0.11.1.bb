SECTION = "console/multimedia"
DESCRIPTION = "curses client for mpd"
HOMEPAGE = "http://www.musicpd.org/ncmpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Hannes Reich <hannes@skynet.ie>"
DEPENDS = "ncurses glib-2.0"
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/ncmpc-${PV}.tar.gz"

inherit autotools



